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


public class CourseRecyclerAdapter6 extends RecyclerView.Adapter<CourseRecyclerAdapter6.MyViewHolder>{

    private final List<Course> recyclerViewItems ;
    private final Context context;
    private OnItemClickListener onItemClickListener;


    public CourseRecyclerAdapter6(List<Course> recyclerViewItems, Context context) {
        this.recyclerViewItems = recyclerViewItems;
        this.context = context;

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

        TextView title, name, price;
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

        public void getSizeItem(int size1, int size2) {
            int itemSize1, itemSize2;
            itemSize1 = size1;
            itemSize2 = size2;


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
//                    if (snapshot.exists()) {
//                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                            courseListModel = new CourseListModel(dataSnapshot.child("courseID").getValue().toString(),
//                                    dataSnapshot.child("courseName").getValue().toString(),
//                                    dataSnapshot.child("courseDetails").getValue().toString());
//
//                            courseList.add(courseListModel);
//
//                        }
//                        int position = getAdapterPosition();
//                        Toast.makeText(context, "1st position " + getAdapterPosition() + " " + recyclerViewItems.get(getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
//
//
//                        Intent intent = new Intent(context, CourseDetailsActivity.class);
//                        intent.putExtra("coursePosition", position);
//                        intent.putExtra("courseDetails", courseList.get(4).getCourseDetails());
//                        intent.putExtra("courseName", courseList.get(4).getCourseName());
//                        intent.putExtra("topicName", recyclerViewItems.get(getAdapterPosition()).getTitle());
//                        Log.i("Tag", "CoursePosition from adapter = " + getAdapterPosition() + "Course tag");
//                        context.startActivity(intent);
//
//
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
        }
    }}
