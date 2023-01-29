package android.widget;

import com.resshare.framework.core.service.ViewOnClickListener;

public interface TextView {

	public void setOnClickListener(ViewOnClickListener lt);

	public CharSequence getText();
	
	public void setTextAlignment(int text);
	public      void   setText(CharSequence text);
	public <T> void getSelectField( String fieldName);
	// public interface CharSequence {}

	public void setVisibility(int gone);
	public void setTextColor(int color);
	public void setBackgroundColor(int color);
	public      void   setTextFromHtml(CharSequence text);
	
}
