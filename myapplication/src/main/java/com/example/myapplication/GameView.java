package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class GameView extends View {
	private int maxvalue;
	private int minvalue;
	private int value;
	int angle=0;
	Context context;
	int c_angle1;
	public GameView(Context context) {
		super(context);
		this.context=context;
		// TODO Auto-generated constructor stub
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context,attrs);
		this.context=context;
		// TODO Auto-generated constructor stub
	}

	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context=context;
		// TODO Auto-generated constructor stub
	}

	Handler handler2 = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if(value==minvalue){
				angle=0;
			}else if(value==maxvalue){
				angle=180;
			}else{
				Log.i("jia", (double)((double)50/(double)100)+"=======");
				double m=(double)value/(double)maxvalue;
				angle=(int)(m*180);
				Log.i("jbl", angle+"========angle");
			}
			
			invalidate();
			super.handleMessage(msg);
		}

	};

	public void setValue(int value) {
		this.value = value;
		handler2.sendEmptyMessage(0);
	}

	public void setMaxValue(int maxvalue) {
		this.maxvalue = maxvalue;

	}

	public void setMinValue(int min) {
		this.minvalue = min;

	}
	public void setColors(int s[]){
		int i=s[1]-s[0];
		double iDouble=(double)i;
		double xDouble=(double)(maxvalue-minvalue);
		Log.i("jbl", "iDouble:"+iDouble);
		Log.i("jbl", "xDouble:"+xDouble);
		double k=iDouble/xDouble;
		Log.i("jbl", "k:"+k);
		double a=(k*(double)180);
		c_angle1=(int)a;
		Log.i("jbl", a + "=========c_angle1");
		
	}

	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		Paint paint = new Paint();
//		paint.setColor(Color.BLACK);
		paint.setAntiAlias(true);
		paint.setDither(true);
		int h=this.getMeasuredHeight();
		int w=this.getMeasuredWidth();
		int pl=this.getPaddingLeft();
//		canvas.drawColor(Color.WHITE);
//		int pt=this.getPaddingTop(); 
//		canvas.setBitmap(bmap);
//		canvas.drawBitmap(bmap, 0, 0, paint);
		paint.setColor(Color.WHITE);
//		int x0 = 300, y0 = 300, r = 250;
		int x0 = w/2-20, y0 = h-40, r = w/2-120;
		int cx0 = x0 + 40, cy0 = y0, r2 = r - 20;
		int cx1=x0+23;
		int cy1=y0;
		paint.setStyle(Paint.Style.STROKE);
		double pingjun = (maxvalue - minvalue) / 9;
		Log.i("jbl", maxvalue + "=========max");
		paint.setTextSize(28);
		for (int i = 0; i <= 180; i += 20) {

			int x1 = (int) (x0 + (r+30) * Math.cos((180 - i) * -Math.PI / 180));
			int y1 = (int) (y0 + (r +20)* Math.sin((180 - i) * -Math.PI / 180));
			if (i == 0) {
				canvas.drawText(minvalue + "", x1, y1, paint);
			} else if (i == 180) {
				canvas.drawText(maxvalue + "", x1, y1, paint);
			} else {
				canvas.drawText((int)(i/20*pingjun) + "", x1, y1,
						paint);
			}

		}
		paint.setStrokeWidth(15);
//		paint.setColor(Color.argb(100, 1,204,0));//绿
		paint.setColor(Color.GREEN);//绿
		canvas.drawArc(new RectF(x0 - r + 25, y0 - r + 10, x0 + r +20, y0 + r),
				180, 60, false, paint);
		Log.i("jbl", c_angle1 + "=========c_angle1");
//		paint.setColor(Color.argb(100, 255,234,1));//黄
		paint.setColor(Color.YELLOW);//黄
		canvas.drawArc(new RectF(x0 - r + 25, y0 - r + 10, x0 + r + 20, y0 + r),
				240, 60, false, paint);
//		paint.setColor(Color.argb(100, 254,0,0));//红
		paint.setColor(Color.RED);//红
		canvas.drawArc(new RectF(x0 - r + 25, y0 - r + 10, x0 + r + 20, y0 + r),
				300, 60, false, paint);
		paint.setStrokeWidth(5);
		for (int i = 0; i <= 180; i += 20) {
			int x1 = (int) (cx1+ + (r2+5 )
					* Math.cos((180 - i) * -Math.PI / 180));
			int y1 = (int) (cy1 + (r2+5 )
					* Math.sin((180 - i) * -Math.PI / 180));
			int x2 = (int) (cx1+ (r2 - 10)
					* Math.cos((180 - i) * -Math.PI / 180));
			int y2 = (int) (cy1 + (r2 - 10)
					* Math.sin((180 - i) * -Math.PI / 180));
			canvas.drawLine(x1, y1, x2, y2, paint);
		}

		int x3 = (int) (cx0 + (r2 - 20) * Math.cos((180 - angle) * -Math.PI / 180));
		int y3 = (int) (cy0 + (r2 - 20) * Math.sin((180 - angle) * -Math.PI / 180));
		 canvas.drawLine(cx0, cy0,x3 , y3, paint);//ָ��
		canvas.drawCircle(cx0,cy0,5,paint);
//		BitmapDrawable bd = (BitmapDrawable) (getResources()
//				.getDrawable(R.drawable.signsec_pointer_01));
//		Bitmap bm = bd.getBitmap();
		canvas.save();
		canvas.rotate(angle, cx0-25, cy0 + 2);
//		canvas.drawBitmap(bm, cx0 - bm.getWidth() +1 , cy0 - bm.getHeight()
//				/ 2, paint);

		canvas.restore();
		// canvas.drawBitmap(bm, matrix, paint);

		Log.d("jia", "draw========ִ��");
		Log.d("jia", angle+"========ִ��");
		
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Log.d("jia", "onDraw========ִ��");
		// TODO Auto-generated method stub
		super.onDraw(canvas);
	}

	class PointThread implements Runnable {

		@Override
		public void run() {
//			while (true) {
////				i += 20;
////				if (i >= 180) {
////					i = 0;
////				}
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				handler2.sendEmptyMessage(0);
////
//			}
//
		}

	}

}
