package Utilities;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
public class ATURecorder {
	ATUTestRecorder recorder ;
	
	public void startRecord(String fileName) throws ATUTestRecorderException
	{
		 recorder  = new ATUTestRecorder(".\\Videos\\",fileName,false);
		 recorder.start();
	}
	
	public void stopRecord() throws ATUTestRecorderException
	{
		 recorder.stop();
	}
}
