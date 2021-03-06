package rise.cocricotlite.util.type.interior;

import net.minecraft.util.IStringSerializable;
import rise.cocricotlite.util.IMetadata;

public enum EnumBedMattress implements IStringSerializable, IMetadata {

    GRAY(0, "gray"),
    WHITE(1, "white"),
    PURPLE(2, "purple"),
    PINK(3, "pink"),
    RED(4, "red"),
    GINGHAM_RED(5, "gingham_red"),
    BROWN(6, "brown"),
    YELLOW(7, "yellow"),
    LIGHT_GREEN(8, "light_green"),
    GREEN(9, "green"),
    LIGHT_BLUE(10, "light_blue"),
    BLUE(11, "blue"),
    DARK_BLUE(12, "dark_blue"),
    BLACK(13, "black");

    private static final EnumBedMattress[] META_LOOKUP = new EnumBedMattress[values().length];
    private final int meta;
    private final String name;

    EnumBedMattress(int meta, String name)
    {
        this.meta = meta;
        this.name = name;
    }

    public int getMetadata()
    {
        return this.meta;
    }

    public String toString()
    {
        return this.name;
    }

    public static EnumBedMattress byMetadata(int meta)
    {
        if(meta < 0 || meta >= META_LOOKUP.length)
        {
            meta = 0;
        }

        return META_LOOKUP[meta];
    }

    public String getName()
    {
        return this.name;
    }

    static
    {
        EnumBedMattress[] var = values();

        for(EnumBedMattress type : var)
        {
            META_LOOKUP[type.getMetadata()] = type;
        }
    }
}
