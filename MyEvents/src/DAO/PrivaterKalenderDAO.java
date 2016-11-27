package DAO;

import main.PrivaterKalender;

public interface PrivaterKalenderDAO {
	public PrivaterKalender getPrivateCal(Integer id);
	public void savePrivateCal();
	public void deletePrivateCal();
}
