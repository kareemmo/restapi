package messanger.kemo.services;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import messanger.kemo.database.DatabaseClass;
import messanger.kemo.exceptions.DataNotFoundException;
import messanger.kemo.model.message;


public class messageService {
	private Map<Long,message> messages=DatabaseClass.getMessages();
	public messageService() {
		if(messages.size()==0){
		messages.put(1L,new message(1,"hello kemoz", "kareem"));
		messages.put(2L,new message(1,"hello medoz", "medo"));
		}
	}
	
	public List<message> getAllMessages(){
		return new ArrayList<message>(messages.values());
	}
	public List<message> getAllMessagesforyear(int year){
		List<message> messagesofyear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(message mess:messages.values()) {
			cal.setTime(mess.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				messagesofyear.add(mess);}
		}
		return messagesofyear;
	}
	public List<message> getAllMessagespaginated(int start,int end){
		ArrayList<message> list=new ArrayList<message>(messages.values());
		return list.subList(start,start+end);
	}
	public message getMessage(long id) {
		
		message message= messages.get(id);
		if(message==null) {
			throw new DataNotFoundException("message with id : "+id+" not found");
		}
		return message;
	}
	public message addMessage(message mes) {
		mes.setId(messages.size()+1);
		messages.put(mes.getId(), mes);
		return mes;
	}
	public message updateMessage(message mes) {
		if(mes.getId()<=0) {return null;}
		messages.put(mes.getId(), mes);
		return mes;
	}
	public message removeMessage(long id) {
		
		return messages.remove(id);
	}

}
