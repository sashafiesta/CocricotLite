package rise.cocricotlite;

import com.google.common.collect.Lists;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import rise.cocricotlite.init.BlockRegistry;
import rise.cocricotlite.init.Recipes;
import rise.cocricotlite.proxy.CommonProxy;
import rise.cocricotlite.util.LogHelper;

@Mod(modid = CocricotLite.MOD_ID, name = CocricotLite.MOD_NAME, version = CocricotLite.MOD_VERSION, useMetadata = true)
public class CocricotLite {

    public static final String MOD_ID = "cocricotlite";
    static final String MOD_NAME = "CocricotLite";
    static final String MOD_VERSION = "1.12.2-r1";

    @SidedProxy(clientSide = "rise.cocricotlite.proxy.ClientProxy", serverSide = "rise.cocricotlite.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Metadata
    private static ModMetadata meta;

    @Mod.EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
        LogHelper.load();
        this.info(meta);
        BlockRegistry.load();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event)
    {
        Recipes.load();
    }

    private void info(ModMetadata meta)
    {
        meta.modId = MOD_ID;
        meta.name = MOD_NAME;
        meta.version = MOD_VERSION;
        meta.authorList = Lists.newArrayList("RiSE4");
        meta.description = "Cocricot Lite";
        meta.autogenerated = false;
    }
}
