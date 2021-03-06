package me.lukas81298.decompiler.instruction.impl;

import me.lukas81298.decompiler.bytecode.constant.ConstantInterfaceMethodRefInfo;
import me.lukas81298.decompiler.bytecode.method.MethodDescriptor;
import me.lukas81298.decompiler.instruction.Context;
import me.lukas81298.decompiler.instruction.ByteCodeInstruction;
import me.lukas81298.decompiler.util.Helpers;
import me.lukas81298.decompiler.util.StackItem;
import me.lukas81298.decompiler.util.VariableStorage;

/**
 * @author lukas
 * @since 26.11.2017
 */
public class InvokeInterfaceAction implements ByteCodeInstruction {

    @Override
    public boolean handle(VariableStorage.PrimitiveType type, int[] data, int pc, Context context) {
        ConstantInterfaceMethodRefInfo methodRef = context.getConstantPool().get(Helpers.mergeFirst(data), ConstantInterfaceMethodRefInfo.class);
        MethodDescriptor methodDescriptor = methodRef.getMethodDescriptor(context.getClassFile());
        String arguments = MethodDescriptor.parseArgumentSignature(methodDescriptor.getArgumentTypes(), context.getStack());
        String name = methodRef.getNameAndType().getName();
        String refName = context.getStack().pop().getRefId();
        String resultString = refName + "." + name + arguments;
        if(methodDescriptor.getReturnType().equals("void")) {
            context.getWriter().println(resultString + ";", context.getLevel());
        } else {
            context.getStack().push(new StackItem(resultString, VariableStorage.PrimitiveType.OBJECT));
        }
        return true;
    }
}
