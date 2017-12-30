package app.test.carecat.carecat1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CareCentreActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Intent intent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_calendar:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_chat:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> mData;

        // 建立ViewHolder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // 宣告元件
            public TextView mTextView;
            public ViewHolder(View v) {
                super(v);
                mTextView = (TextView) v.findViewById(R.id.info_text);

                // 點擊項目時
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(view.getContext(),
                                "click " +getAdapterPosition(),Toast.LENGTH_SHORT).show();
                        intent = new Intent(CareCentreActivity.this, SingleCentreActivity.class);
                        startActivity(intent);
                    }
                });
            }
        }

        public MyAdapter(List<String> data) {
            mData = data;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 連結項目布局檔list_item
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // 設置mTextView要顯示的內容
            holder.mTextView.setText(mData.get(position));

        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_centre);

        mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
       // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //使用Spinner
        Spinner careCentreCategory = (Spinner)findViewById(R.id.careCentreCategory);
        ArrayAdapter<CharSequence> careCentreCategory_nAdapter = ArrayAdapter.createFromResource(
                this, R.array.careCentreCategory_array, android.R.layout.simple_spinner_item );
        careCentreCategory_nAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        careCentreCategory.setAdapter(careCentreCategory_nAdapter);
        String text = careCentreCategory.getSelectedItem().toString();

        //使用Spinner
        Spinner careCentreCity = (Spinner)findViewById(R.id.careCentreCity);
        ArrayAdapter<CharSequence> careCentreCity_nAdapter = ArrayAdapter.createFromResource(
                this, R.array.careCentreCity_array, android.R.layout.simple_spinner_item );
        careCentreCity_nAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        careCentreCity.setAdapter(careCentreCity_nAdapter);

        ArrayList<String> myDataset = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            myDataset.add(i + "");
        }
        MyAdapter myAdapter = new MyAdapter(myDataset);
        RecyclerView mList = (RecyclerView) findViewById(R.id.list_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        mList.setAdapter(myAdapter);
    }

}
