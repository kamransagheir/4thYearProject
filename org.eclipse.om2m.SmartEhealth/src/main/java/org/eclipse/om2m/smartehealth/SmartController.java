
package org.eclipse.om2m.smartehealth;

import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.ShortName;
import org.eclipse.om2m.commons.resource.ContentInstance;
import org.eclipse.om2m.core.service.CseService;


public class SmartController {
	
	public static CseService CSE;
	protected static String AE_ID;
	
	public static void setPatient(String appID, String randIdNum,String namePatient, String loc , String treatType, String preOrder, String phName){
		// Set the value in the "real world" model
			// Send the information to the CSE
		String targetID = SmartConstants.CSE_PREFIX + "/" + appID + "/" + SmartConstants.DATA;
		ContentInstance cin = new ContentInstance();
		//encryption 
		cin.setContent(ObixUtil.getStateRep(appID, randIdNum,namePatient, loc , treatType, preOrder, phName));
		cin.setName(randIdNum);
		cin.setContentInfo(MimeMediaType.OBIX + ":" + MimeMediaType.ENCOD_PLAIN);
		RequestSender.createContentInstance(targetID, cin);
	}

	
	public static String getData(String appID, String randNum) {
		String str = randNum;
		String targetId = SmartConstants.CSE_PREFIX + "/" + appID + "/" + SmartConstants.DATA +"/" + str + ShortName.CONTENT;
		return RequestSender.getRequest(targetId).toString();
	}
	
	public static void addData(String randIdNum,String namePatient, String loc , String treatType, String preOrder, String phName ){
		setPatient(SmartConstants.AE_NAME, randIdNum,namePatient, loc , treatType, preOrder, phName );
	}

	
	public static void setCse(CseService cse){
		CSE = cse;
	}
	
	
}
