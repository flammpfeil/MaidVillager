package mods.flammpfeil.maidvillager;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelWitch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;

public class ModelMaidWitch extends ModelWitch
{
    public ModelSimpleLittleMaid maid;
    public ModelRenderer hat;

    public ModelMaidWitch(float par1)
    {
        super(par1);
        maid = new ModelSimpleLittleMaid(64, 64);
        ModelRenderer tmp;
        hat = tmp = maid.initMR(maid.bipedHead, -5.0F, -9.5F, -5.0F)
                    .setTextureOffset(0, 32);
        tmp.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.25f);
        tmp.rotateAngleX = -0.15f;
        tmp.rotateAngleZ = 0.03f;
        tmp = maid.initMR(hat, 1.75F, -4.25F, 2.0F)
              .setTextureOffset(0, 44).addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
        tmp.rotateAngleX = 1 * -0.05235988F;
        tmp.rotateAngleZ = 0.0261799F;
        tmp = maid.initMR(tmp, 1.75F, -4.0F, 2.0F)
              .setTextureOffset(0, 55).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
        tmp.rotateAngleX = 2 * -0.1047198F;
        tmp.rotateAngleZ = 0.05235988F;
        tmp = maid.initMR(tmp, 1.75F, -2.0F, 2.0F)
              .setTextureOffset(0, 55);
        tmp.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
        tmp.rotateAngleX = 2 * -0.2094395F;
        tmp.rotateAngleZ = 0.1047198F;
    }
    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        maid.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        maid.render(par1Entity, par2, par3, par4, par5, par6, par7);
    }
}
