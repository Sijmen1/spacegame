package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	private Vector3f position = new Vector3f(0,0,0);
	private float pitch;
	private float yaw;
	private float roll;
	private float speed = 0.09f;
	
	public Camera() {}
	public Vector3f getPosition() {
		return position;
	}
	
	public void move() {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			if(yaw<90){
				position.z -= speed*((90-yaw)/90);
				position.x +=(speed*((yaw)/90));	
			}
			
			if(yaw>=90 && yaw<180){
				float yaw2 = Math.abs(yaw - 180);
				position.z += speed*((90-yaw2)/90);
				position.x +=(speed*((yaw2)/90));
				
			}
			
			if(yaw>=180 && yaw<270) {
				float yaw2 = yaw - 180;
				position.x -= speed*((yaw2)/90);
				position.z += speed*((90-yaw2)/90);
			}
			
			if(yaw>=270){
				float yaw2=Math.abs(yaw-360);
				position.z -= speed*((90-yaw2)/90);
				position.x -=(speed*((yaw2)/90));
			}
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_R)) {
			position = new Vector3f(0,0,0);
			float pitch = 0;
			float yaw = 0;
			float roll = 0;
			
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			position.x += speed;}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			position.x -= speed;}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			position.z += speed;}
		if(Keyboard.isKeyDown(Keyboard.KEY_E)) {
			yaw +=1.5f;
			if (yaw > 359) {
				yaw -= 360 ; 
			}

			//System.out.println(yaw);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Q)) {
			
			yaw -=1.5f;
			if(yaw < 0) {
				yaw += 360;
			}
			//System.out.println(yaw);
		}
		
	}
	
	
	public float getPitch() {
		return pitch;
	}
	public float getYaw() {
		return yaw;
	}
	public float getRoll() {
		return roll;
	}
	
	
}
