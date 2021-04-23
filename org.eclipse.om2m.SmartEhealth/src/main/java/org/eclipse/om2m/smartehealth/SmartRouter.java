
package org.eclipse.om2m.smartehealth;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.om2m.commons.constants.MimeMediaType;
import org.eclipse.om2m.commons.constants.ResponseStatusCode;
import org.eclipse.om2m.commons.exceptions.BadRequestException;
import org.eclipse.om2m.commons.resource.RequestPrimitive;
import org.eclipse.om2m.commons.resource.ResponsePrimitive;
import org.eclipse.om2m.interworking.service.InterworkingService;

public class SmartRouter implements InterworkingService{

	private static Log LOGGER = LogFactory.getLog(SmartRouter.class);

	@Override
	public ResponsePrimitive doExecute(RequestPrimitive request) {
		ResponsePrimitive response = new ResponsePrimitive(request);
		if(request.getQueryStrings().containsKey("op")){
			String operation = request.getQueryStrings().get("op").get(0);
			//Operations op = Operations.getOperationFromString(operation);
			String sysID= null;
			if(request.getQueryStrings().containsKey("sysID")){
				sysID = request.getQueryStrings().get("sysID").get(0);
			}
			LOGGER.info("Received request in Smart E-healthIPE: op=" + operation + " ; sysID=" + sysID);
			
			/*
			switch(op){
			case SET_ON:
				SampleController.setLampState(sysID, true);
				response.setResponseStatusCode(ResponseStatusCode.OK);
				break;
			case SET_OFF:
				SampleController.setLampState(sysID, false);
				response.setResponseStatusCode(ResponseStatusCode.OK);
				break;
			case TOGGLE:
				SampleController.toggleLamp(sysID);
				response.setResponseStatusCode(ResponseStatusCode.OK);
				break;
			case ALL_ON:
				SampleController.setAllOn();
				response.setResponseStatusCode(ResponseStatusCode.OK);
				break;
			case ALL_OFF:
				SampleController.setAllOff();
				response.setResponseStatusCode(ResponseStatusCode.OK);
				break;
			case ALL_TOGGLE:
				SampleController.toogleAll();
            	response.setResponseStatusCode(ResponseStatusCode.OK);
            	break;
			case GET_STATE:
				// Shall not get there...
				throw new BadRequestException();
			case GET_STATE_DIRECT:
				String content = SampleController.getFormatedLampState(sysID);
				response.setContent(content);
				request.setReturnContentType(MimeMediaType.OBIX);
				response.setResponseStatusCode(ResponseStatusCode.OK);
				break;
			default:
				throw new BadRequestException();
			}
		}
		if(response.getResponseStatusCode() == null){
			response.setResponseStatusCode(ResponseStatusCode.BAD_REQUEST);
		}
		*/
		response.setResponseStatusCode(ResponseStatusCode.OK);
		return response;
		}
		return response;
	}

	@Override
	public String getAPOCPath() {
		return SmartConstants.POA;
	}
	
}
