import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class AnimatorFixedObject {
	
	
	boolean running = false;
	ArrayList<BufferedImage> frames;
	BufferedImage sprite;
	public long previousTime, speed;
	public int frameAtPause, currentFrame;
	
	public AnimatorFixedObject(ArrayList<BufferedImage> frames) {
		this.frames = frames;
	}
	
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	
	public void update(long time) {
		if (running) {
			if (time - previousTime >= speed) {
				currentFrame++;
				try {
					sprite = frames.get(currentFrame);
				} catch (IndexOutOfBoundsException e) {
					running = false;
					currentFrame = 0;
					sprite = frames.get(currentFrame);
				}
				previousTime = time;
			}
		}
	}
	
	
	public void start() {
		running = true;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	
	public void stop() {
		running = false;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	
}
