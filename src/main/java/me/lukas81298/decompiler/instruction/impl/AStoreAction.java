package me.lukas81298.decompiler.instruction.impl;

import me.lukas81298.decompiler.instruction.Context;
import me.lukas81298.decompiler.instruction.ByteCodeInstruction;
import me.lukas81298.decompiler.util.VariableStorage;

/**
 * @author lukas
 * @since 26.11.2017
 */
public class AStoreAction implements ByteCodeInstruction {

    @Override
    public boolean handle(VariableStorage.PrimitiveType type, int[] data, int pc, Context context) {
        String value = context.getStack().pop().getRefId();
        String index = context.getStack().pop().getRefId();
        String array = context.getStack().pop().getRefId();
        context.getWriter().println(array + "[" + index + "] = " + value + ";", context.getLevel());
        return true;
    }
}
