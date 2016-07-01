package com.myhostelmanager.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myhostelmanager.dao.LoginDao;
import com.myhostelmanager.model.Block;
import com.myhostelmanager.model.Login;

@Service("loginService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	private List<Login> loginList;
	
	@Override
	public boolean isUserValid(String id, String pswd) {
		loginList = loginDao.getUser(id, pswd);
//		System.out.println("Size:"+loginList.size());
		Iterator itr = loginList.iterator();
		boolean status = false;
        while(itr.hasNext())
        {
        	Login l=(Login)itr.next();
//            System.out.println(l.getUid()+"  "+l.getPwd()+" "+l.getHid());
            if(id.equals(l.getUid()) && pswd.equals(l.getPwd())){
            	status = true;
            }
            else{
            	status = false;
            }
        }
        return status;
	}


	@Override
	public String getHostelId(String id, String pswd) {
		Iterator itr = loginList.iterator();
		String hostelId = "";
        while(itr.hasNext())
        {
        	Login l = (Login)itr.next();
//            System.out.println(l.getUid()+"  "+l.getPwd()+" "+l.getHid());
            if(id.equals(l.getUid()) && pswd.equals(l.getPwd())){
            	hostelId = l.getHid();
            }
        }
		return hostelId;
	}


	@Override
	public List<Block> getBlocks(String hostelId) {
		List<Block> blockList = loginDao.getBlocks(hostelId);
		System.out.println("No of. Block Records:"+blockList.size());
		Iterator itr = blockList.iterator();
        while(itr.hasNext())
        {
        	Block block=(Block)itr.next();
            System.out.println("Block ID:"+block.getBid()+"  Block Name:"+block.getBname()+"  HostelID:"+block.getHid());
        }	
		return blockList;
	}


	@Override
	public String getHostelName(String hostelId) {
		return loginDao.getHostelName(hostelId);
	}
	
}
