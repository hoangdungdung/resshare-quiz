package android.view;

import java.io.Serializable;

public class View {

public interface OnClickListener extends Serializable {

	void onClick(View v);
	 
	  
}
public static final int VISIBLE = 0x00000000;

/**
 * This view is invisible, but it still takes up space for layout purposes.
 * Use with {@link #setVisibility} and <a href="#attr_android:visibility">{@code
 * android:visibility}.
 */
public static final int INVISIBLE = 0x00000004;

/**
 * This view is invisible, and it doesn't take any space for layout
 * purposes. Use with {@link #setVisibility} and <a href="#attr_android:visibility">{@code
 * android:visibility}.
 */
public static final int GONE = 0x00000008;
 


}
