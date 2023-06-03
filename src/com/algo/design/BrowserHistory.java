package com.algo.design;

public class BrowserHistory {

	public static void main(String[] args) {

	}
	
	class Page{
		Page prev;
		Page next;
		String url;
		private Page() {}
		private Page(String url) {
			super();
			this.url = url;
		}
	}

	Page current;
	
    public BrowserHistory(String homepage) {
        current = new Page(homepage);
    }
    
    public void visit(String url) {
        Page temp = new Page(url);
        temp.prev = current;
        current.next = temp;
        current = temp;
    }
    
    public String back(int steps) {
        while(steps-- > 0 && current.prev != null){
        	current = current.prev;
        }
        return current.url;
    }
    
    public String forward(int steps) {
        while(steps-- > 0 && current.next != null){
        	current = current.next;
        }
        return current.url;        
    }	
	
}
