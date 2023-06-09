package com.example.educational_app.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.educational_app.R;
import com.example.educational_app.activity.CourseDetailsActivity;
import com.example.educational_app.model.Course;
import com.example.educational_app.model.CourseListModel;
//import com.google.firebase.database.*;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.MyViewHolder>{

    private final List<Course> recyclerViewItems ;
    private final Context context;
    private OnItemClickListener onItemClickListener;
    int itemSize1,itemSize2,itemSize3,itemSize4,itemSize5;

    public CourseRecyclerAdapter(List<Course> recyclerViewItems, Context context,int size1, int size2,int size3,int size4,int size5) {
        this.recyclerViewItems = recyclerViewItems;
        this.context = context;
        this.itemSize1 = size1;
        this.itemSize2= size2;
        this.itemSize3= size3;
        this.itemSize4= size4;
        this.itemSize5= size5;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_course_item, parent, false);
        return new MyViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
        Course recyclerViewItem = recyclerViewItems.get(position);
        Glide.with(context)
                .load(recyclerViewItem.getImageUrl())
                .fitCenter()
                .into(holders.imageView);

        holders.title.setText(recyclerViewItem.getTitle());
        holders.name.setText(recyclerViewItem.getName());
        Locale locale = new Locale("hi","IN");
        NumberFormat format = NumberFormat.getCurrencyInstance(locale);
        holders.price.setText(format.format(Integer.parseInt(recyclerViewItem.getPrice())));

    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        TextView title,name,price;
        ImageView imageView;

        OnItemClickListener onItemClickListener;

        public MyViewHolder(View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            itemView.setOnClickListener(this);
            title = itemView.findViewById(R.id.title);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            imageView = itemView.findViewById(R.id.img);
            this.onItemClickListener = onItemClickListener;
        }

        CourseListModel courseListModel;

        @Override
        public void onClick(View v) {
//            FirebaseDatabase mFirebaseDatabase;
//            DatabaseReference mDatabaseReference;
//            mFirebaseDatabase = FirebaseDatabase.getInstance();
//            mDatabaseReference = mFirebaseDatabase.getReference();
            List<CourseListModel> courseList = new ArrayList<>();

//            mDatabaseReference.child("coursesList").addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    if(snapshot.exists()){
//                        for (DataSnapshot dataSnapshot: snapshot.getChildren()){
//                            courseListModel = new CourseListModel(dataSnapshot.child("courseID").getValue().toString(),
//                                    dataSnapshot.child("courseName").getValue().toString(),
//                                    dataSnapshot.child("courseDetails").getValue().toString());
//
//                            courseList.add(courseListModel);
//
//                        }
//                        int position = getAdapterPosition();
//                        if(position>=0 && position<itemSize1){
//                            Toast.makeText(context, "1st position " + getAdapterPosition()+" "+recyclerViewItems.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
//
//
//                            Intent intent= new Intent(context, CourseDetailsActivity.class);
//                            intent.putExtra("coursePosition",position);
//                            intent.putExtra("courseDetails",courseList.get(0).getCourseDetails());
//                            intent.putExtra("courseName",courseList.get(0).getCourseName());
//                            intent.putExtra("topicName",recyclerViewItems.get(getAdapterPosition()).getTitle());
//                            Log.i("Tag","CoursePosition from adapter = "+getAdapterPosition()+"Course tag");
//                            context.startActivity(intent);
//
//
//                        }else if(position>=itemSize1 && position<(itemSize1+itemSize2)) {
//                            int tempPosition;
//                            tempPosition = position-itemSize1;
//                            Toast.makeText(context, "2nd position  " + tempPosition, Toast.LENGTH_SHORT).show();
//                            Intent intent= new Intent(context, CourseDetailsActivity.class);
//                            intent.putExtra("coursePosition",tempPosition);
//                            intent.putExtra("courseDetails",courseList.get(1).getCourseDetails());
//                            intent.putExtra("courseName",courseList.get(1).getCourseName());
//                            intent.putExtra("topicName",recyclerViewItems.get(getAdapterPosition()).getTitle());
//                            Log.i("Tag","CoursePosition from adapter: = "+itemSize1+" size2: "+itemSize2);
//                            context.startActivity(intent);
//                        }
//                        else if(position>=(itemSize1+itemSize2) && position<(itemSize1+itemSize2+itemSize3)) {
//                            int tempPosition;
//                            tempPosition = position-(itemSize1+itemSize2);
//                            Toast.makeText(context, "3rd position  " + tempPosition, Toast.LENGTH_SHORT).show();
//                            Intent intent= new Intent(context, CourseDetailsActivity.class);
//                            intent.putExtra("coursePosition",tempPosition);
//                            intent.putExtra("courseDetails",courseList.get(2).getCourseDetails());
//                            intent.putExtra("courseName",courseList.get(2).getCourseName());
//                            intent.putExtra("topicName",recyclerViewItems.get(getAdapterPosition()).getTitle());
//                            Log.i("Tag","CoursePosition from adapter: = "+itemSize1+" size3: "+itemSize2);
//                            context.startActivity(intent);
//                        }else if(position>=(itemSize1+itemSize2+itemSize3) && position<(itemSize1+itemSize2+itemSize3+itemSize4)) {
//                            int tempPosition;
//                            tempPosition = position-(itemSize1+itemSize2+itemSize3);
//                            Toast.makeText(context, "4th position  " + tempPosition, Toast.LENGTH_SHORT).show();
//                            Intent intent= new Intent(context, CourseDetailsActivity.class);
//                            intent.putExtra("coursePosition",tempPosition);
//                            intent.putExtra("courseDetails",courseList.get(3).getCourseDetails());
//                            intent.putExtra("courseName",courseList.get(3).getCourseName());
//                            intent.putExtra("topicName",recyclerViewItems.get(getAdapterPosition()).getTitle());
//                            Log.i("Tag","CoursePosition from adapter: = "+itemSize1+" size3: "+itemSize2);
//                            context.startActivity(intent);
//                        }else if(position>=(itemSize1+itemSize2+itemSize3+itemSize4) && position<(itemSize1+itemSize2+itemSize3+itemSize4+itemSize5)) {
//                            int tempPosition;
//                            tempPosition = position-(itemSize1+itemSize2+itemSize3+itemSize4);
//                            Toast.makeText(context, "4th position  " + tempPosition, Toast.LENGTH_SHORT).show();
//                            Intent intent= new Intent(context, CourseDetailsActivity.class);
//                            intent.putExtra("coursePosition",tempPosition);
//                            intent.putExtra("courseDetails",courseList.get(4).getCourseDetails());
//                            intent.putExtra("courseName",courseList.get(4).getCourseName());
//                            intent.putExtra("topicName",recyclerViewItems.get(getAdapterPosition()).getTitle());
//                            Log.i("Tag","CoursePosition from adapter: = "+itemSize1+" size3: "+itemSize2);
//                            context.startActivity(intent);
//                        }
//                    }
//                }
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
        }
    }
}