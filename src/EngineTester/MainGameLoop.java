package EngineTester;

import java.util.ArrayList;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import Models.RawModel;
import Models.TexturedModel;
import entities.Camera;
import entities.Entity;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplayManager.createDisplay();
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		ArrayList<Entity> entities = new ArrayList();
		float[] vertices = {			
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,0.5f,-0.5f,		
				
				-0.5f,0.5f,0.5f,	
				-0.5f,-0.5f,0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				0.5f,0.5f,-0.5f,	
				0.5f,-0.5f,-0.5f,	
				0.5f,-0.5f,0.5f,	
				0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,-0.5f,	
				-0.5f,-0.5f,-0.5f,	
				-0.5f,-0.5f,0.5f,	
				-0.5f,0.5f,0.5f,
				
				-0.5f,0.5f,0.5f,
				-0.5f,0.5f,-0.5f,
				0.5f,0.5f,-0.5f,
				0.5f,0.5f,0.5f,
				
				-0.5f,-0.5f,0.5f,
				-0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,-0.5f,
				0.5f,-0.5f,0.5f
				
		};
		
		float[] textureCoords = {
				
				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,			
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0,
				0,0,
				0,1,
				1,1,
				1,0

				
		};
		
		int[] indices = {
				0,1,3,	
				3,1,2,	
				4,5,7,
				7,5,6,
				8,9,11,
				11,9,10,
				12,13,15,
				15,13,14,	
				16,17,19,
				19,17,18,
				20,21,23,
				23,21,22

		};
		RawModel model = loader.loadToVAO(vertices,textureCoords,indices);
		ModelTexture texture = new ModelTexture(loader.loadTextures("naamloos"));
		TexturedModel texturedModel = new TexturedModel(model, texture);
		int i = 0;
		while(i!=5) {
			int i2 = 0;
			while(i2!=5) {
				Entity entity = new Entity(texturedModel, new Vector3f(-4+(3*i),0,-4+(3*i2)), 0, 0, 0,(float) Math.random()*3);
				entities.add(entity);
				i2++;
				
			}
			
			i++;
			
			
		}
		
		
		
		
		
		

		//Entity entity = new Entity(texturedModel, new Vector3f(0,0,-5), 0, 0, 0, 6f);
		Camera camera = new Camera();
		while(!Display.isCloseRequested()) {
			
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadViewMatrix(camera);
			for(Entity entity: entities) {
				renderer.render(entity, shader);
				
			}
			//renderer.render(entity,shader);

			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.cleanup();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
