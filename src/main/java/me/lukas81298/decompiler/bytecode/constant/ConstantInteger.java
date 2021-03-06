package me.lukas81298.decompiler.bytecode.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.lukas81298.decompiler.bytecode.ConstantPool;

/**
 * @author lukas
 * @since 27.11.2017
 */
@RequiredArgsConstructor
@Getter
public class ConstantInteger implements Constant {

    private final ConstantPool constantPool;
    private final int value;

    @Override
    public ConstantType getType() {
        return ConstantType.INTEGER;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
