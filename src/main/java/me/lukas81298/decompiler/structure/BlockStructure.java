package me.lukas81298.decompiler.structure;

import gnu.trove.set.hash.TIntHashSet;
import me.lukas81298.decompiler.exception.DecompileException;
import me.lukas81298.decompiler.stack.Block;
import me.lukas81298.decompiler.stack.StackActionRegistry;
import me.lukas81298.decompiler.util.IndentedPrintWriter;
import me.lukas81298.decompiler.util.Parser;

/**
 * @author lukas
 * @since 24.11.2017
 */
public abstract class BlockStructure extends AbstractStructure {

    protected final static StackActionRegistry STACK_ACTION_REGISTRY = new StackActionRegistry();

    @Override
    public void parse(IndentedPrintWriter out, Parser parser, int level) throws DecompileException {
        if(!parser.getAndRemove().equals("Code:")) {
            throw  new DecompileException("Missing 'Code:'");
        }
        Block block = new Block(level, out,  new TIntHashSet(), parser);
        do {
            String line = parser.getAndRemove();
            if(line.isEmpty()) {
                continue;
            }
            if(line.equals("}")) {
                return;
            }
            if(!STACK_ACTION_REGISTRY.invoke(block, line)) {
                return;
            }

        } while(parser.hasNext());
        throw new DecompileException("Unexpected end of statement collection");
    }

}
