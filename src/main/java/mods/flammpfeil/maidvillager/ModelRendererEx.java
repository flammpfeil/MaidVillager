package mods.flammpfeil.maidvillager;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;

public class ModelRendererEx extends ModelRenderer {

	int displayList = 0;
	boolean compiled = false;

	public ModelRendererEx(ModelBase par1ModelBase) {
		super(par1ModelBase);
	}

    @SideOnly(Side.CLIENT)
    private void compileDisplayList(float par1)
    {
        this.displayList = GLAllocation.generateDisplayLists(1);
        GL11.glNewList(this.displayList, GL11.GL_COMPILE);
        Tessellator tessellator = Tessellator.instance;

        for (int i = 0; i < this.cubeList.size(); ++i)
        {
            ((ModelBox)this.cubeList.get(i)).render(tessellator, par1);
        }

        GL11.glEndList();
        this.compiled = true;
    }

	@Override
	public void render(float par1) {


		super.render(par1);


        if (!this.isHidden)
        {
            if (!this.compiled)
            {
                this.compileDisplayList(par1);
            }

            GL11.glTranslatef(this.offsetX, this.offsetY, this.offsetZ);
            int i;

            if (this.rotateAngleX == 0.0F && this.rotateAngleY == 0.0F && this.rotateAngleZ == 0.0F)
            {
                if (this.rotationPointX == 0.0F && this.rotationPointY == 0.0F && this.rotationPointZ == 0.0F)
                {
                    if (this.showModel)
                    {
                    	GL11.glCallList(this.displayList);
                    }

                    if (this.childModels != null)
                    {
                        for (i = 0; i < this.childModels.size(); ++i)
                        {
                            ((ModelRenderer)this.childModels.get(i)).render(par1);
                        }
                    }
                }
                else
                {
                    GL11.glTranslatef(this.rotationPointX * par1, this.rotationPointY * par1, this.rotationPointZ * par1);

                    if (this.showModel)
                    {
                    	GL11.glCallList(this.displayList);
                    }
                    if (this.childModels != null)
                    {
                        for (i = 0; i < this.childModels.size(); ++i)
                        {
                            ((ModelRenderer)this.childModels.get(i)).render(par1);
                        }
                    }

                    GL11.glTranslatef(-this.rotationPointX * par1, -this.rotationPointY * par1, -this.rotationPointZ * par1);
                }
            }
            else
            {
                GL11.glPushMatrix();
                GL11.glTranslatef(this.rotationPointX * par1, this.rotationPointY * par1, this.rotationPointZ * par1);

                if (this.rotateAngleZ != 0.0F)
                {
                    GL11.glRotatef(this.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
                }

                if (this.rotateAngleY != 0.0F)
                {
                    GL11.glRotatef(this.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
                }

                if (this.rotateAngleX != 0.0F)
                {
                    GL11.glRotatef(this.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
                }


                if (this.showModel)
                {
                	GL11.glCallList(this.displayList);
                }

                if (this.childModels != null)
                {
                    for (i = 0; i < this.childModels.size(); ++i)
                    {
                        ((ModelRenderer)this.childModels.get(i)).render(par1);
                    }
                }

                GL11.glPopMatrix();
            }

            GL11.glTranslatef(-this.offsetX, -this.offsetY, -this.offsetZ);
        }
	}
}
