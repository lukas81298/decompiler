package me.lukas81298.decompiler.bytecode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lukas
 * @since 27.11.2017
 */
@Getter
@RequiredArgsConstructor
public enum MethodFlag {

    ACC_PUBLIC(0x0001, "public"),
    ACC_PRIVATE(0x0002, "private"),
    ACC_PROTECTED(0x0004, "protected"),
    ACC_STATIC(0x0008, "static"),
    ACC_FINAL(0x0010, "final"),
    ACC_SYNCHRONIZED(0x0020, "synchronized"),
    ACC_BRIDGE(0x0040),
    ACC_VARARGS(0x0080),
    ACC_NATIVE(0x0100, "native"),
    ACC_ABSTRACT(0x4000, "abstract"),
    ACC_STRICT(0x800),
    ACC_SYNTHETIC(0x1000);

    private final int value;
    private final String name;

    MethodFlag(int value) {
        this.value = value;
        this.name = null;
    }

    public static Set<MethodFlag> fromBitMask(int bitMask) {
        Set<MethodFlag> set = new HashSet<>();
        for(MethodFlag classFlag : values()) {
            if((bitMask & classFlag.getValue()) == classFlag.getValue()) {
                set.add(classFlag);
            }
        }
        return set;
    }
}
