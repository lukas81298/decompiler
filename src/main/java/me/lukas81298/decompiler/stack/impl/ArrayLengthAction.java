package me.lukas81298.decompiler.stack.impl;

import me.lukas81298.decompiler.stack.Block;
import me.lukas81298.decompiler.stack.StackAction;
import me.lukas81298.decompiler.util.VariableStorage;

/**
 * @author lukas
 * @since 26.11.2017
 */
public class ArrayLengthAction implements StackAction {

    @Override
    public boolean handle(VariableStorage.PrimitiveType type, String arg, String comment, int lineNumber, Block block) {
        block.getOperandStack().add(new VariableStorage.Variable(block.getOperandStack().remove(0).getRefId() + ".length", VariableStorage.PrimitiveType.OBJECT));
        return true;
    }
}
