package com.dxc.service;

import java.util.List;


import com.dxc.beans.Mark;

public interface MarkService {

	boolean save(Mark mark);
	Mark find (int id);
	List<Mark>findAll();
	boolean update(Mark mark);
	boolean delete(int id);
}
