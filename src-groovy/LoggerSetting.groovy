import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class LoggerSetting {
	
	public static void setLog(String logName,String msg,String type) {
	   Logger logger = LoggerFactory.getLogger(logName)
	   if (type == 'trace') logger.trace(msg)
	   else if (type == 'debug') logger.debug(msg + "_$type")
	   else if (type == 'error') logger.error(msg)
	   else logger.info(msg + "_$type")
	   
	}
	public static void setLogInfo(String logName,String msg) {
		Logger logger = LoggerFactory.getLogger(logName)
		logger.info(msg)
		
	 }
	
	static void main(String[] args) {
		//setLogInfo('testlog',"infoclasstest")
		//setLog('testlog','testing debug type','debug')
	 }
 }