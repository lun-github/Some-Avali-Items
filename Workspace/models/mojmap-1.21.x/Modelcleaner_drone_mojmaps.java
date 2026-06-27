// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcleaner_drone_mojmaps<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "cleaner_drone_mojmaps"), "main");
	private final ModelPart Body;

	public Modelcleaner_drone_mojmaps(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(0, 0)
						.addBox(-5.0F, -2.5F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(28, 15)
						.addBox(-4.0F, -2.5F, -6.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 12)
						.addBox(-4.0F, -2.5F, 5.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(18, 21)
						.addBox(5.0F, -2.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 21)
						.addBox(-6.0F, -2.5F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-1.0F, -4.5F, 2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(10, 21)
						.addBox(-2.0F, -2.75F, 1.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(10, 26)
						.addBox(-2.0F, -3.35F, -2.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(28, 23)
						.addBox(-1.0F, -3.35F, -5.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 8)
						.addBox(-0.5F, -3.6F, -4.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 12)
						.addBox(-5.0F, -1.0F, -4.0F, 10.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(28, 21)
						.addBox(-4.0F, -1.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 18)
						.addBox(-4.0F, -1.0F, 4.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition eye_r1 = Body.addOrReplaceChild("eye_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-1.05F, 0.45F, -1.0F, 2.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, -3.0F, -4.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition eye_r2 = Body.addOrReplaceChild("eye_r2",
				CubeListBuilder.create().texOffs(0, 4).addBox(-0.95F, 0.45F, -1.0F, 2.0F, 1.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, -3.0F, -4.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}