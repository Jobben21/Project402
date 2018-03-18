package com.example.cs.peojec401;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainDishFragment extends Fragment
{
    private TextView mTextViewEmpty;
    private ProgressBar mProgressBarLoading;
    private ImageView mImageViewEmpty;
    private RecyclerView mRecyclerView;
    private ListAdapter mListadapter;
    private Button cardView;
    private static final String TAG = "MainDishFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main_dish, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);



        ArrayList data = new ArrayList<Food>();
        for (int i = 0; i < DataNoteImformation.id.length; i++)
        {
            data.add(
                    new Food
                            (
                                    DataNoteImformation.Menufood[i],
                                    DataNoteImformation.textArray[i],
                                    DataNoteImformation.dateArray[i],
                                    DataNoteImformation.maindish_food[i],
                                    DataNoteImformation.maindish_image[i]

                            ));
        }

        mListadapter = new ListAdapter(data);
        mRecyclerView.setAdapter(mListadapter);



        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
        private ArrayList<Food> dataList;
        Dialog mydialog;


        public ListAdapter(ArrayList<Food> data) {
            this.dataList = data;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            ImageView Menufood;
            TextView textViewComment;
            TextView textViewDate;
            TextView maindish_food;
            TextView maindish_image;

            public ViewHolder(View itemView) {
                super(itemView);
                this.Menufood = (ImageView)itemView.findViewById(R.id.menufood);
                this.textViewComment = (TextView) itemView.findViewById(R.id.comment);
                this.textViewDate = (TextView) itemView.findViewById(R.id.date);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_food2, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);

           /* mydialog = new Dialog(parent.getContext());
            mydialog.setContentView(R.layout.content_food_dialog);
            ImageView imageview = (ImageView)mydialog.findViewById(R.id.MainDish_image);
            TextView dialog = (TextView)mydialog.findViewById(R.id.MainDish_food);

            imageview.setImageResource(dataList.get(viewHolder.getAdapterPosition()).getMenufood());
            dialog.setText(dataList.get(viewHolder.getAdapterPosition()).getComment());
*/


            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position) {
            holder.Menufood.setImageResource(dataList.get(position).getMenufood());
            holder.textViewComment.setText(dataList.get(position).getComment());
            holder.textViewDate.setText(dataList.get(position).getDate());

        //    Log.d(TAG," onClick:Click on ");
          //  ImageView imageviewfood = (ImageView)mydialog.findViewById(R.id.MainDish_image);
          //  TextView textfood = (TextView)mydialog.findViewById(R.id.MainDish_food);

           // imageviewfood.setImageResource(dataList.get(position).getMenufood());
           // textfood.setText(dataList.get(position).getComment());



            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(getActivity().getBaseContext(),DocumentFood.class);
                 //   intent.putExtra("imageview",imageviewfood);
                 //   intent.putExtra("textfood",textfood);
                    startActivity(intent);


                }
            });
        }

        @Override
        public int getItemCount() {
            return dataList.size();
        }


    }

    public void onClickMenu(){


    }
}