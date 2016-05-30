package com.sleepfuriously.customdrawablestest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * Test to figure out to make custom state-dependent graphics
 * using the XML drawables.  More specifically, I'm trying to
 * figure out how to set the states of a drawable so that it
 * can be highlighted or not AND still have ripple effects
 * in both cases.
 *
 * google's dox:
 *  @see <a href="https://developer.android.com/guide/topics/resources/drawable-resource.html#StateList">Google's Ref Page</a>
 *
 * Here's my recipe:
 *      1.  In the java code, make the widget's onTouch (or
 *      onClick if you prefer) toggle its Activated state.
 *<br><br>
 *      2.  Set your colors for the highlighted color and the
 *      normal color.  In my example, the normal state is
 *      transparent, which is a little counter-intuitive to code.
 *<br><br>
 *      3.  Create your drawables.  For compatibility, you'll need
 *      a drawable-v21/ directory for the ripple effects with matching
 *      files in regular drawable/ directory.
 *<br><br>
 *      3a.  Create the ripple drawable for the normal (unselected
 *      color (again, two versions for compatibility).
 *<br><br>
 *      3b.  Create teh ripple drawable for the highlighted
 *      color and its old-school twin.
 *<br><br>
 *      3c.  Create a drawable that defines how the backgrounds
 *      change depending on state of the widget. See my selectable.xml
 *      for an example.
 *<br><br>
 *      4.  Set the background of the widget to use the drawable
 *      from 3c.
 *
 */
public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView tv = (TextView) findViewById(R.id.push_me_tv);
		assert tv != null;  // gets rid of warning

		// Use onTouch() to control more specifically when
		// the button's Activated state happens.
//		tv.setOnTouchListener(new View.OnTouchListener() {
//			@Override
//			public boolean onTouch(View v, MotionEvent event) {
//				// Only listen for release
//				if (event.getAction() == MotionEvent.ACTION_UP) {
//					v.setActivated(!v.isActivated());   // Toggle activation of widget.
//				}
//				return false;
//			}
//		});

		// onClick() happens as soon as the widget is touched.
		tv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				v.setActivated(!v.isActivated());   // Toggle activation of widget.
			}
		});

	} // onCreate(.)

}
