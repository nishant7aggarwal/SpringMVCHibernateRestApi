package com.apex.info.bo;

import com.apex.info.vo.User;

public interface InfoBOInterface {
abstract public String addInfo(User user, String id);

/* public abstract String addBank(User user, String id); */

public abstract String addAddress(User user, String id);

public abstract String addBank(User user, User userAddress, User userPersonal);
}
