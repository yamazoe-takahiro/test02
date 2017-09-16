package jp.a_frontier.iot.server;

import java.lang.management.ManagementFactory;
import java.text.SimpleDateFormat;

import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ServiceContext;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.engine.ServiceLifeCycle;
import org.apache.axis2.service.Lifecycle;
import org.apache.log4j.Logger;

public class TemperatureDataStorageServer 
implements Lifecycle ,ServiceLifeCycle
{
	
	protected static Logger log = Logger.getLogger( TemperatureDataStorageServer.class ); 
	
	final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss.SSS");
	
	
	final public static String RETURN_OK = "0000";
	final public static String RETURN_NG = "9999";

	static {
		System.out.println("["+TemperatureDataStorageServer.class+"]static�C�j�V�����C�U:" + Thread.currentThread().getName());
	}

	@Override
	public void startUp(ConfigurationContext arg0, AxisService arg1) {
		log.info("startUp[Start]");
		
		log.info("startUp[End]");
		
	}

	@Override
	public void init(ServiceContext arg0) throws AxisFault {
		
		log.info("init()");
		log.info("CPU: " + ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors());
		
		ConfigurationContext configurationContext = arg0.getConfigurationContext();
		String getContextRoot =  configurationContext.getContextRoot();
		log.info("ContextRoot= " + getContextRoot);
		
		long totalMemory = Runtime.getRuntime().totalMemory();
		log.info("totalMemory: " + totalMemory);

		long freeMemory = Runtime.getRuntime().freeMemory();
		log.info("freeMemory: " + freeMemory);
	}

	
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	public String sendTemperatureData(String param){
		
		String returnCode = RETURN_NG;
		log.info("param=["+param+"]");
		
		//
		// �����ɃN���C�A���g�����M�����f�[�^���g����
		// DB�o�^��A���[�Ə����Ȃǂ��L�ڂ���
		//
		
		returnCode = RETURN_OK;
		return returnCode;
	}
	
	
	/**
	 * services.xml��scope��"application"�Œ�`����ƁA
	 * ������iTomcat�X���b�h�����s�x�j�Ăяo����Ȃ��Ȃ�B
	 */
	@Override
	public void destroy(ServiceContext arg0) {
		
		log.info("destroy()");

		
		log.info("destroy():service.shutdown()[End]");
	}

	
	@Override
	public void shutDown(ConfigurationContext arg0, AxisService arg1) {
		log.info("shutDown[Start]");
		
		log.info("shutDown[End]");
	}

}
