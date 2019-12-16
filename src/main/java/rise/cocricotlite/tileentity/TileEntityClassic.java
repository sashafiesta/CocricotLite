package rise.cocricotlite.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
import rise.cocricotlite.util.type.interior.EnumClassic;

public class TileEntityClassic extends BaseTileEntity  {

    private EnumClassic type = EnumClassic.WHITE_PIANO;

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);

        if(tag.hasKey("type", Constants.NBT.TAG_BYTE))
        {
            this.type = EnumClassic.byMetadata(tag.getByte("type"));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setByte("type", (byte) type.getMetadata());
        return tag;
    }

    public EnumClassic getType()
    {
        return this.type;
    }

    public void setType(EnumClassic type)
    {
        this.type = type;
    }
}
