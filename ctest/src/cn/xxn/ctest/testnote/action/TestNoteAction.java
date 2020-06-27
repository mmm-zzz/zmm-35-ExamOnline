package cn.xxn.ctest.testnote.action;

import cn.xxn.ctest.testnote.entity.TestNote;
import cn.xxn.ctest.testnote.service.TestNoteService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestNoteAction extends ActionSupport implements ModelDriven<TestNote>{
	private TestNote testNote = new TestNote();
	public TestNote getModel() {
		return testNote;
	}
	private TestNoteService tnService;
	public void setTnService(TestNoteService tnService) {
		this.tnService = tnService;
	}
	//¿¼ÊÔ½áÊø
	public String closeTestNote(){
		System.out.println("¿¼ÊÔ¼ÇÂ¼id"+testNote.getTnid());
		tnService.upEndTime(testNote.getTnid());
		return "closeTestNote";
	}
}
