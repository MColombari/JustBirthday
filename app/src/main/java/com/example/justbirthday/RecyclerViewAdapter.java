package com.example.justbirthday;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    ArrayList<SingleRowRecycleView> singleRowRecycleViewArrayList;

    public RecyclerViewAdapter(ArrayList<SingleRowRecycleView> singleRowRecycleViewArrayList) {
        this.singleRowRecycleViewArrayList = singleRowRecycleViewArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        SingleRowRecycleView singleRowRecycleView = singleRowRecycleViewArrayList.get(position);
        holder.getNikNameRVRTextView().setText(singleRowRecycleView.getNikName());
        holder.getNameRVRTextView().setText(singleRowRecycleView.getName());
        holder.getSurnameRVRTextView().setText(singleRowRecycleView.getSurname());
        holder.getDateRVRTextView().setText(singleRowRecycleView.getBirthdayDate().toString());
        holder.getBirthdayRVRTextView().setText(singleRowRecycleView.getBirthdayDate().toString());
        holder.getCommentsRVRTextView().setText(singleRowRecycleView.getComments());

        boolean isExpanded = singleRowRecycleView.isExpanded();
        holder.getMoreDetailConstraintLayoutRVR().setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return singleRowRecycleViewArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nikNameRVRTextView;
        private TextView dateRVRTextView;
        private TextView nameRVRTextView;
        private TextView surnameRVRTextView;
        private TextView birthdayRVRTextView;
        private TextView commentsRVRTextView;
        private ImageView iconRVRow;
        private Button changeInformationRVRButton;
        private Button deleteRVRButton;
        ConstraintLayout moreDetailConstraintLayoutRVR;
        ConstraintLayout mainLayoutRVRConstraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nikNameRVRTextView = (TextView) itemView.findViewById(R.id.NikNameRVRTextView);
            iconRVRow = (ImageView) itemView.findViewById(R.id.IconRVRImageView);
            dateRVRTextView = (TextView) itemView.findViewById(R.id.DateRVRTextView);
            nameRVRTextView = (TextView) itemView.findViewById(R.id.NameRVRTextView);
            surnameRVRTextView = (TextView) itemView.findViewById(R.id.SurnameRVRTextView);
            birthdayRVRTextView = (TextView) itemView.findViewById(R.id.BirthdayRVRTextView);
            commentsRVRTextView = (TextView) itemView.findViewById(R.id.CommentsRVRTextView);
            changeInformationRVRButton = (Button) itemView.findViewById(R.id.ChangeInformationRVRButton);
            deleteRVRButton = (Button) itemView.findViewById(R.id.DeleteRVRButton);
            moreDetailConstraintLayoutRVR = (ConstraintLayout) itemView.findViewById(R.id.MoreDetailConstraintLayoutRVR);
            mainLayoutRVRConstraintLayout = (ConstraintLayout) itemView.findViewById(R.id.MainLayoutRVRConstraintLayout);

            mainLayoutRVRConstraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(singleRowRecycleViewArrayList.get(position).isExpanded() == false){
                        for(int i = 0; i < getItemCount(); i++){
                            SingleRowRecycleView singleRowRecycleView = singleRowRecycleViewArrayList.get(i);
                            singleRowRecycleView.setExpanded(i == position ? true : false);
                            notifyItemChanged(i);
                        }
                    }
                    else{
                        singleRowRecycleViewArrayList.get(position).setExpanded(false);
                        notifyItemChanged(position);
                    }
                }
            });
        }

        public TextView getNikNameRVRTextView() {
            return nikNameRVRTextView;
        }
        public TextView getDateRVRTextView() {
            return dateRVRTextView;
        }
        public TextView getNameRVRTextView() {
            return nameRVRTextView;
        }
        public TextView getSurnameRVRTextView() {
            return surnameRVRTextView;
        }
        public TextView getBirthdayRVRTextView() {
            return birthdayRVRTextView;
        }
        public TextView getCommentsRVRTextView() {
            return commentsRVRTextView;
        }
        public ImageView getIconRVRow() {
            return iconRVRow;
        }
        public Button getChangeInformationRVRButton() {
            return changeInformationRVRButton;
        }
        public Button getDeleteRVRButton() {
            return deleteRVRButton;
        }
        public ConstraintLayout getMoreDetailConstraintLayoutRVR() {
            return moreDetailConstraintLayoutRVR;
        }
        public ConstraintLayout getMainLayoutRVRConstraintLayout() {
            return mainLayoutRVRConstraintLayout;
        }
    }
}
