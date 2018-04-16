package edu.wpi.mams.cs.tan_project;
/*Patrick Tan
 * Ver: 1.4
 * 
 */

import java.io.File;

import javax.security.auth.login.Configuration;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;

import com.darkprograms.speech.microphone.Microphone;
import com.darkprograms.speech.recognizer.GoogleResponse;
import com.darkprograms.speech.recognizer.Recognizer;

import net.sourceforge.javaflacencoder.FLACFileWriter;



public class Ball extends Sprite implements Functions {

	//private int xdir;
	//private int ydir;
	private int dx;
	private int dy;
	
	public Ball() throws Exception {

		dx = 0;
		dy = 0;
		
		width = 10;
		height = 10;
		
		
		resetState();
	}
	
	public void move() throws Exception {
		AudioFileFormat.Type[] typeArray = AudioSystem.getAudioFileTypes();
	    for(AudioFileFormat.Type type : typeArray) {
	       System.out.println("type: " + type.toString());
	    } 

	    Microphone mic = new Microphone(FLACFileWriter.FLAC);
	    File file = new File ("C:\\tmp\\testfile2.flac");	//location of file
	    try {
	      mic.captureAudioToFile (file);
	    } catch (Exception ex) {
	      //Microphone not available or some other error.
	      System.out.println ("ERROR: Microphone is not availible.");
	      ex.printStackTrace ();
	    }

	    /* User records the voice here. Microphone starts a separate thread so do whatever you want
	     * in the mean time. Show a recording icon or whatever.
	     */
	    try {
	      System.out.println ("Recording...");
	      Thread.sleep (5000);	//In our case, we'll just wait 5 seconds.
	      mic.close ();
	    } catch (InterruptedException ex) {
	      ex.printStackTrace ();
	    }

	    mic.close ();		//Ends recording and frees the resources
	    System.out.println ("Recording stopped.");

	    Recognizer recognizer = new Recognizer (Recognizer.Languages.ENGLISH_US, "AIzaSyDzmb84measFNKZWYs_N3yD_Y4OpNbiHuM");
	    //Although auto-detect is available, it is recommended you select your region for added accuracy.
	    try {
	      int maxNumOfResponses = 4;
	      System.out.println("Sample rate is: " + (int) mic.getAudioFormat().getSampleRate());
	      GoogleResponse response = recognizer.getRecognizedDataForFlac (file, maxNumOfResponses, (int) mic.getAudioFormat().getSampleRate ());
	      System.out.println ("Google Response: " + response.getResponse ());
	      if(response!=null) {
	    	  if(response.getResponse().contains("right")) {
		    	  x+=30;
		      }
		      else if(response.getResponse().contains("left")) {
		    	  x-=30;
		      }
		      else if(response.getResponse().contains("up") || response.getResponse().contains("forward")) {
		    	  y-=30;
		      }
		      else if(response.getResponse().contains("down") || response.getResponse().contains("backward")) {
		    	  y+=30;
		      }
	      }
	    }
	    catch (Exception ex) {
	      // TODO Handle how to respond if Google cannot be contacted
	      /*System.out.println ("ERROR: Google cannot be contacted");
	      ex.printStackTrace ();*/
	    }

	    file.deleteOnExit ();	//Deletes the file as it is no longer necessary.
		
		if (x <= 0) {
			x = 0;
		}
		if (x >= WIDTH - width) {
			x = WIDTH - width;
		}
		
		if (y <= 0) {
			y = 0;
		}
			
		if (y >= INIT_BALL_Y ) {
			y = INIT_BALL_Y;
		}
	
	}

	private void resetState() {

		x = INIT_BALL_X;
		y = INIT_BALL_Y;
	}

	public void setdx(int x) {
		dx = x;
	}

	public void setdy(int y) {
		dy = y;
	}

	public int getdy() {
		return dy;
	}

}