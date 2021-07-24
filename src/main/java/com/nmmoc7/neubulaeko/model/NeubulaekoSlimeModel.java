package com.nmmoc7.neubulaeko.model;// Made with Blockbench 3.9.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class NeubulaekoSlimeModel extends EntityModel<Entity> {
	private final ModelRenderer leg_left;
	private final ModelRenderer leg_right;
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer bone;
	private final ModelRenderer arm_left;
	private final ModelRenderer cube_r3;
	private final ModelRenderer head;
	private final ModelRenderer bone2;
	private final ModelRenderer arm_right;
	private final ModelRenderer cube_r4;

	public NeubulaekoSlimeModel() {
		textureWidth = 128;
		textureHeight = 128;

		leg_left = new ModelRenderer(this);
		leg_left.setRotationPoint(-1.75F, 16.0F, -0.5F);
		leg_left.setTextureOffset(0, 32).addBox(-0.75F, 1.8F, -1.0F, 2.0F, 4.0F, 2.0F, -0.11F, false);

		leg_right = new ModelRenderer(this);
		leg_right.setRotationPoint(1.75F, 16.0F, -0.5F);
		leg_right.setTextureOffset(0, 32).addBox(-1.25F, 1.8F, -1.0F, 2.0F, 4.0F, 2.0F, -0.11F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(-0.25F, 14.0F, -0.5F);
		body.setTextureOffset(0, 40).addBox(-2.25F, 2.0F, -1.0F, 5.0F, 2.0F, 2.0F, 0.01F, false);
		body.setTextureOffset(0, 44).addBox(-1.75F, -3.0F, -1.0F, 4.0F, 5.0F, 2.0F, 0.01F, false);
		body.setTextureOffset(12, 73).addBox(-0.75F, -3.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-2.25F, 2.0F, -0.5F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.1745F);
		cube_r1.setTextureOffset(10, 51).addBox(0.0F, -3.0F, -0.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(2.75F, 2.0F, -1.5F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -0.1745F);
		cube_r2.setTextureOffset(10, 51).addBox(-1.0F, -3.0F, 0.5F, 1.0F, 3.0F, 2.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 3.0F, 1.0F);
		body.addChild(bone);
		

		arm_left = new ModelRenderer(this);
		arm_left.setRotationPoint(2.0F, 11.75F, -0.5F);
		

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		arm_left.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.3491F);
		cube_r3.setTextureOffset(13, 32).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 22.75F, 0.0F);
		head.setTextureOffset(0, 63).addBox(-3.0F, -18.0F, -3.5F, 6.0F, 6.0F, 6.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addChild(bone2);
		bone2.setTextureOffset(0, 61).addBox(-1.0F, -17.0F, -4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(0.0F, -16.0F, -4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(0.0F, -15.0F, -4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(0.0F, -17.0F, -4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.0F, -17.0F, -4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(1.0F, -16.1F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.0F, -17.0F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.5F, -17.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.5F, -16.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(2.6F, -16.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.7F, -15.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.6F, -14.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.5F, -13.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.5F, -12.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.7F, -16.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(2.5F, -16.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.6F, -15.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.6F, -15.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.5F, -14.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.5F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(2.6F, -15.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.7F, -14.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.5F, -12.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.6F, -13.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.5F, -14.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.5F, -13.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.7F, -16.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(2.6F, -16.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.5F, -15.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.25F, -14.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.25F, -13.0F, -3.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.25F, -12.0F, -3.75F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-2.0F, -16.75F, -4.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.25F, -17.85F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.35F, -17.75F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.45F, -17.65F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.0F, -17.65F, 1.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.0F, -17.75F, 1.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-1.0F, -17.65F, 1.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.0F, -17.75F, 1.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.4F, -17.75F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.4F, -17.95F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.3F, -17.85F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.4F, -17.75F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.35F, -17.75F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.6F, -17.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.5F, -17.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(2.5F, -17.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.6F, -17.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.5F, -17.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(2.0F, -17.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.0F, -16.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(2.0F, -15.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.0F, -14.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.0F, -13.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.0F, -12.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(1.0F, -14.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(0.0F, -14.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(0.0F, -13.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-1.0F, -13.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(0.0F, -12.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-1.0F, -14.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-2.0F, -14.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-2.0F, -13.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-2.0F, -12.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-2.0F, -11.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.0F, -14.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-3.0F, -13.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-3.0F, -15.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-3.0F, -16.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.0F, -16.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-1.0F, -16.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(1.0F, -16.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.0F, -16.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(1.0F, -15.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-1.0F, -15.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-2.0F, -15.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(0.0F, -15.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.0F, -17.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.0F, -17.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-1.0F, -17.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.0F, -17.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-3.5F, -16.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.6F, -16.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-3.6F, -16.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.7F, -15.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.5F, -15.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.6F, -15.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-3.5F, -15.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.5F, -14.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.7F, -14.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.6F, -13.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.5F, -12.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-3.7F, -16.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.5F, -16.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-3.6F, -16.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-3.6F, -15.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-3.5F, -15.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.5F, -14.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.6F, -14.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.5F, -13.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.7F, -14.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.6F, -13.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.5F, -12.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.5F, -17.0F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-3.5F, -17.0F, 0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.6F, -17.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.5F, -17.0F, -1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.5F, -18.35F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-1.5F, -18.45F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-1.5F, -18.35F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-1.5F, -18.45F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-0.5F, -18.45F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.5F, -18.45F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.5F, -18.45F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.5F, -18.35F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-0.5F, -18.45F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-0.5F, -18.45F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.5F, -18.25F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-1.5F, -18.35F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-0.5F, -18.25F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.5F, -18.25F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.5F, -18.35F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.5F, -18.45F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.5F, -18.35F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.5F, -18.25F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.5F, -18.35F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.5F, -18.25F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-0.5F, -18.35F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-1.5F, -18.25F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.5F, -18.35F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.5F, -18.35F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.5F, -18.25F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.5F, -17.0F, -3.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-3.6F, -17.0F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.0F, -17.0F, 2.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(2.0F, -16.0F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(2.0F, -15.0F, -3.95F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(2.0F, -14.0F, -3.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-1.0F, -16.0F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.0F, -17.0F, -4.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-2.0F, -17.75F, -4.25F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(0.0F, -17.75F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(1.0F, -17.5F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-2.75F, -17.5F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-1.0F, -17.8F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 61).addBox(-3.0F, -17.0F, -4.15F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 59).addBox(-3.0F, -16.0F, -4.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 57).addBox(-3.0F, -15.0F, -4.05F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(0, 55).addBox(-3.0F, -14.0F, -3.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		arm_right = new ModelRenderer(this);
		arm_right.setRotationPoint(-2.0F, 11.75F, -0.5F);
		

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
		arm_right.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.3491F);
		cube_r4.setTextureOffset(13, 32).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 5.0F, 2.0F, 0.0F, true);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		leg_left.render(matrixStack, buffer, packedLight, packedOverlay);
		leg_right.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		arm_left.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		arm_right.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}