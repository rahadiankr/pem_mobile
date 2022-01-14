    package com.example.uas_ppb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class noteActivity extends AppCompatActivity {

    FloatingActionButton createnote, btnkal;
    private FirebaseAuth firebaseAuth;

    RecyclerView recyclerView;
    StaggeredGridLayoutManager staggeredGridLayoutManager;


    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;

    FirestoreRecyclerAdapter<firebasemodel, NotViewHolder> noteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        createnote=findViewById(R.id.createnote);
        firebaseAuth=FirebaseAuth.getInstance();
        btnkal=findViewById(R.id.kalku);

        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        firebaseFirestore=FirebaseFirestore.getInstance();


        getSupportActionBar().setTitle("All Notes");


        createnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(noteActivity.this,note.class));
            }
        });

        btnkal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(noteActivity.this,kalkulator.class));
            }
        });

        Query query=firebaseFirestore.collection("notes").document(firebaseUser.getUid()).collection("CatatanKu").orderBy("title",Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<firebasemodel>allusernotes=new FirestoreRecyclerOptions.Builder<firebasemodel>().setQuery(query,firebasemodel.class).build();

        noteAdapter= new FirestoreRecyclerAdapter<firebasemodel, NotViewHolder>(allusernotes){
            @Override
            protected void onBindViewHolder(@NonNull NotViewHolder notViewHolder, int i, @NonNull firebasemodel firebasemodel) {

                notViewHolder.createtitlenote.setText(firebasemodel.getTitle());
                notViewHolder.createcontentnote.setText(firebasemodel.getContent());

            }

            @NonNull
            @Override
            public NotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                return null;
            }
        };


        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(noteAdapter);

    }


    public class NotViewHolder extends RecyclerView.ViewHolder{

        private TextView createtitlenote;
        private TextView createcontentnote;
        LinearLayout note;

        public NotViewHolder(@NonNull View itemView) {
            super(itemView);
            createtitlenote=itemView.findViewById(R.id.createtitlenote);
            createcontentnote=itemView.findViewById(R.id.createcontentnote);
            note=itemView.findViewById(R.id.note);


        }
    }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {

            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId())
            {
                case R.id.logout:
                    firebaseAuth.signOut();
                    finish();
                    startActivity(new Intent(noteActivity.this,MainActivity.class));
            }
            return super.onOptionsItemSelected(item);
        }

        @Override
        protected void onStart() {
            super.onStart();
            noteAdapter.startListening();
        }
        @Override
        protected void onStop() {
            super.onStop();
            if(noteAdapter!=null){
                noteAdapter.toString();
            }
        }
    }