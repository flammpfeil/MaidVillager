package mods.flammpfeil.maidvillager;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSimpleLittleMaid extends ModelBase
{
    /** The head box of the VillagerModel */
    public ModelRenderer root;
    public ModelRenderer bipedHead;
    public ModelRenderer bipedHeadwear;
    public ModelRenderer bipedBody;
    public ModelRenderer bipedRightArm;
    public ModelRenderer bipedLeftArm;
    public ModelRenderer bipedRightLeg;
    public ModelRenderer bipedLeftLeg;
    public ModelRenderer Skirt;
    public ModelRenderer ChignonR;
    public ModelRenderer ChignonL;
    public ModelRenderer ChignonB;
    public ModelRenderer Tail;
    public ModelRenderer SideTailR;
    public ModelRenderer SideTailL;

    public ModelSimpleLittleMaid()
    {
        this(64, 32);
    }
    public ModelSimpleLittleMaid(int width, int height)
    {
        init(0.0F, width, height);
    }

    /**
     *
     * @param parent
     * @param f2 textureSizeX
     * @param f3 textureSizeY
     * @param rpX
     * @param rpY
     * @param rpZ
     * @param u
     * @param v
     * @return
     */
    public ModelRenderer initMR(ModelRenderer parent,
                                float rpX, float rpY, float rpZ)
    {
        ModelRenderer tmp = new ModelRendererEx(this);
        parent.addChild(tmp);
        tmp.setTextureSize((int)parent.textureWidth, (int)parent.textureHeight);
        tmp.setRotationPoint(rpX, rpY, rpZ);
        return tmp;
    }

    public ModelRenderer init(float f1, int f2, int f3)
    {
        root = new ModelRenderer(this).setTextureSize(f2, f3);
        root.setRotationPoint(0F, 8F, 0F);
        bipedHead = initMR(root, 0, f1, 0)
                    .setTextureOffset(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        //bipedHead.setTextureOffset(0,0).addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8,-1.0f);
        {
            bipedHeadwear = initMR(bipedHead, 0, f1, 0)
                            .setTextureOffset(24, 0).addBox(-4.0F, 0.0F, 1.0F, 8, 4, 3);
            ChignonR = initMR(bipedHead, 0, f1, 0)
                       .setTextureOffset(24, 18).addBox(-5.0F, -7.0F, -0.2F, 1, 3, 3);
            ChignonL = initMR(bipedHead, 0, f1, 0)
                       .setTextureOffset(24, 18).addBox(4.0F, -7.0F, 0.2F, 1, 3, 3);
            ChignonB = initMR(bipedHead, 0, f1, 0)
                       .setTextureOffset(52, 10).addBox(-2.0F, -7.2F, 4.0F, 4, 4, 2);
            Tail = initMR(bipedHead, 0, f1, 0)
                   .setTextureOffset(46, 20).addBox(-1.5F, -6.8F, 4.0F, 3, 9, 3);
            SideTailR = initMR(bipedHead, 0, f1, 0)
                        .setTextureOffset(58, 21).addBox(-5.5F, -6.8F, 0.9F, 1, 8, 2);
            SideTailL = initMR(bipedHead, 0, f1, 0)
                        .setTextureOffset(58, 21).addBox(4.5F, -6.8F, 0.9F, 1, 8, 2);
        }
        bipedBody = initMR(root, 0, f1, 0)
                    .setTextureOffset(32, 8).addBox(-3.0F, -3.5F, -2.0F, 6, 7, 4);
        {
            bipedRightArm = initMR(bipedBody, -3.0F, -3.0F, 0.0F)
                            .setTextureOffset(48, 0).addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
            bipedLeftArm = initMR(bipedBody, 3.0F, -3.0F, 0.0F)
                           .setTextureOffset(56, 0).addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
            bipedRightLeg = initMR(bipedBody, -1.5F, 15F, 0.0F)
                            .setTextureOffset(32, 19).addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4);
            bipedLeftLeg = initMR(bipedBody, 1.5F, 15F, 0.0F)
                           .setTextureOffset(32, 19).addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4);
            Skirt = initMR(bipedBody, 0.0F, 4.0F, 0.0F)
                    .setTextureOffset(0, 16).addBox(-4F, -4F, -4F, 8, 8, 8);
        }
        return root;
    }

    @Override
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        root.render(par7);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        final float radFact = 180F / (float)Math.PI;
        bipedHead.rotateAngleY = f3 / radFact;
        bipedHead.rotateAngleX = f4 / radFact;
        bipedRightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        bipedLeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        bipedRightArm.rotateAngleZ = 0.0F;
        bipedLeftArm.rotateAngleZ = 0.0F;
        bipedRightLeg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F
                                     * f1;
        bipedLeftLeg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI)
                                    * 1.4F * f1;
        bipedRightLeg.rotateAngleY = 0.0F;
        bipedLeftLeg.rotateAngleY = 0.0F;

        if (entity.isRiding())
        {
            bipedRightArm.rotateAngleX += -((float)Math.PI / 5F);
            bipedLeftArm.rotateAngleX += -((float)Math.PI / 5F);
            bipedRightLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            bipedLeftLeg.rotateAngleX = -((float)Math.PI * 2F / 5F);
            bipedRightLeg.rotateAngleY = ((float)Math.PI / 10F);
            bipedLeftLeg.rotateAngleY = -((float)Math.PI / 10F);
        }

        bipedBody.rotateAngleX = 0.0F;
        Skirt.rotationPointZ = 0.0F;
        Skirt.rotateAngleX = 0.0F;
        Skirt.rotationPointY = 5.5F;
        bipedHead.rotationPointY = 0.0F;
        bipedBody.rotationPointY = 3.5F;
        bipedBody.rotationPointZ = 0.0F;
        bipedRightLeg.rotationPointY = bipedLeftLeg.rotationPointY = 3.5F;
        bipedRightArm.rotateAngleZ += 0.5F;
        bipedLeftArm.rotateAngleZ -= 0.5F;
        bipedRightArm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        bipedLeftArm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
        bipedRightArm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
        bipedLeftArm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
    }
}
