package management;

import user.Veranstalter;

public class VeranstalterManagement {
	
	public void addIDtoMyEvents(Integer id){
		Veranstalter.addEventToMyEvents(id);
	}
	
	public void removeIDfromMyEvents(Integer id){
		Veranstalter.removeEventFromMyEvents(id);
	}

}
