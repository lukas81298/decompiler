package me.lukas81298.decompiler.stack.impl;

import me.lukas81298.decompiler.stack.Block;
import me.lukas81298.decompiler.stack.StackAction;
import me.lukas81298.decompiler.util.VariableStorage;

/**
 * @author lukas
 * @since 26.11.2017
 */
public class NegAction implements StackAction {

    @Override
    public boolean handle(VariableStorage.PrimitiveType type, String arg, String comment, int pc, Block block) {
        VariableStorage.Variable remove = block.getOperandStack().remove(0);
        block.getOperandStack().add(new VariableStorage.Variable("-" + remove.getRefId(), remove.getType()));
        return true;
    }
}
