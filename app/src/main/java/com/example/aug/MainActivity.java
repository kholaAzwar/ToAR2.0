package com.example.aug;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    private ModelRenderable serenaRenderable,centaurusRenderable,
            faisalmosqueRenderable,monumentRenderable,libraryRenderable, conventionRenderable,
    parlimentRenderable, niceRenderable, nustgatethreeRenderable, nustgatetenRenderable,nustmosqueRenderable, seecsRenderable;

    ImageView serena,centaurus,faisalmosque,monument,library,convention,parliment,nice, nustgatethree,nustgateten,
    nustmosque,seecs;

    View[] arrayView;



    int selected ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment =(ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        serena = (ImageView)findViewById(R.id.serena);
        centaurus = (ImageView)findViewById(R.id.centaurus);
        faisalmosque = (ImageView)findViewById(R.id.faisalmosque);
        monument = (ImageView)findViewById(R.id.monument);
        library = (ImageView)findViewById(R.id.nustlibrary);  //At other places 'library' was used
       convention = (ImageView)findViewById(R.id.convention);
        parliment = (ImageView)findViewById(R.id.parliment);
       nice = (ImageView)findViewById(R.id.nice);
       nustgatethree = (ImageView)findViewById(R.id.nustgatethree);
       nustgateten = (ImageView)findViewById(R.id.nustgateten);
       nustmosque = (ImageView)findViewById(R.id.nustmosque);
        seecs = (ImageView)findViewById(R.id.seecs);

    setArrayView();
    setClickListener();
    setupModel();
    arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
        @Override
        public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {


           Anchor anchor= hitResult.createAnchor();
           AnchorNode anchorNode = new AnchorNode(anchor);
           anchorNode.setParent(arFragment.getArSceneView().getScene());

           createModel(anchorNode,selected);

       }


    });


    }

    private void setupModel() {



        ModelRenderable.builder()
                .setSource(this, R.raw.serena)
                .build().thenAccept(renderable -> serenaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load SERENA model", Toast.LENGTH_SHORT).show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.centaurus)
                .build().thenAccept(renderable -> centaurusRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load centaurus model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.faisalmosque)
                .build().thenAccept(renderable -> faisalmosqueRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load faisalmosque model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

       ModelRenderable.builder()
                .setSource(this, R.raw.monument)
                .build().thenAccept(renderable -> monumentRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load monument model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.library)
                .build().thenAccept(renderable -> libraryRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load library model", Toast.LENGTH_SHORT).show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.convention)
                .build().thenAccept(renderable -> conventionRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load convention model", Toast.LENGTH_SHORT).show();
                            return null;
                        });
       ModelRenderable.builder()
                .setSource(this, R.raw.parliment)
                .build().thenAccept(renderable -> parlimentRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load parliment model", Toast.LENGTH_SHORT).show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.nice)
                .build().thenAccept(renderable -> niceRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load NICE model", Toast.LENGTH_SHORT).show();
                            return null;
                        });

        ModelRenderable.builder()
                .setSource(this, R.raw.nustgatethree)
                .build().thenAccept(renderable -> nustgatethreeRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load nustgatethree model", Toast.LENGTH_SHORT).show();
                            return null;
                        });
       ModelRenderable.builder()
                .setSource(this, R.raw.nustgateten)
                .build().thenAccept(renderable -> nustgatetenRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load nustgateten model", Toast.LENGTH_SHORT).show();
                            return null;
                        });
        ModelRenderable.builder()
                .setSource(this, R.raw.nustmosque)
                .build().thenAccept(renderable -> nustmosqueRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load nustmosque model", Toast.LENGTH_SHORT).show();
                            return null;
                        });
       ModelRenderable.builder()
                .setSource(this, R.raw.seecs)
                .build().thenAccept(renderable -> seecsRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Unable to load seecs model", Toast.LENGTH_SHORT).show();
                            return null;
                        });}


    private void createModel(AnchorNode anchorNode, int selected) {
    if(selected == 1)
    {
        TransformableNode serena = new TransformableNode(arFragment.getTransformationSystem());
        serena.setParent(anchorNode);
        serena.setRenderable(serenaRenderable);
        serena.select();

        addName(anchorNode,serena,"SERENA");

    }
      if(selected == 2)
        {
            TransformableNode centaurus = new TransformableNode(arFragment.getTransformationSystem());
            centaurus.setParent(anchorNode);
            centaurus.setRenderable(centaurusRenderable);
            centaurus.select();

            addName(anchorNode,centaurus,"centaurus");

        }

     if(selected == 3)
        {
            TransformableNode faisalmosque = new TransformableNode(arFragment.getTransformationSystem());
            faisalmosque.setParent(anchorNode);
            faisalmosque.setRenderable(faisalmosqueRenderable);
            faisalmosque.select();

            addName(anchorNode,faisalmosque,"faisalmosque");

        }
     if(selected == 4)
        {
            TransformableNode monument = new TransformableNode(arFragment.getTransformationSystem());
            monument.setParent(anchorNode);
            monument.setRenderable(monumentRenderable);
            monument.select();

            addName(anchorNode,monument,"monument");

        }
     if(selected == 5)
        {
            TransformableNode library = new TransformableNode(arFragment.getTransformationSystem());
            library.setParent(anchorNode);
            library.setRenderable(libraryRenderable);
            library.select();

            addName(anchorNode,library,"library");

        }
    if(selected == 6)
        {
            TransformableNode convention = new TransformableNode(arFragment.getTransformationSystem());
            convention.setParent(anchorNode);
            convention.setRenderable(conventionRenderable);
            convention.select();

            addName(anchorNode,convention,"convention");

        }

    if(selected == 7)
        {
            TransformableNode parliment = new TransformableNode(arFragment.getTransformationSystem());
            parliment .setParent(anchorNode);
            parliment .setRenderable(parlimentRenderable);
            parliment .select();

            addName(anchorNode,parliment ,"parliment ");

        }
    if(selected == 8)
        {
            TransformableNode nice = new TransformableNode(arFragment.getTransformationSystem());
            nice.setParent(anchorNode);
            nice.setRenderable(niceRenderable);
            nice.select();

            addName(anchorNode,nice,"nice");

        }
     if(selected == 9)
        {
            TransformableNode nustgatethree = new TransformableNode(arFragment.getTransformationSystem());
            nustgatethree.setParent(anchorNode);
            nustgatethree.setRenderable(nustgatethreeRenderable);
            nustgatethree.select();

            addName(anchorNode,nustgatethree,"nustgatethree");

        }
    if(selected == 10)
        {
            TransformableNode nustgateten = new TransformableNode(arFragment.getTransformationSystem());
            nustgateten.setParent(anchorNode);
            nustgateten.setRenderable(nustgatetenRenderable);
            nustgateten.select();

            addName(anchorNode,nustgateten,"nustgateten");

        }
    if(selected == 11)
        {
            TransformableNode nustmosque = new TransformableNode(arFragment.getTransformationSystem());
            nustmosque.setParent(anchorNode);
            nustmosque.setRenderable(nustmosqueRenderable);
            nustmosque.select();

            addName(anchorNode,nustmosque,"nustmosque");

        }
     if(selected == 12)
        {
            TransformableNode seecs = new TransformableNode(arFragment.getTransformationSystem());
            seecs.setParent(anchorNode);
            seecs.setRenderable(seecsRenderable);
            seecs.select();

            addName(anchorNode,seecs,"seecs");

        }

    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {
       /* final ViewRenderable name_building;
        ViewRenderable.builder()
                        .setView(this, R.layout.name_building)
                        .build()
                        .thenAccept(renderable ->name_building = renderable );
*/
        ViewRenderable.builder().setView(this,R.layout.name_building)
                .build()
                .thenAccept(viewRenderable -> {

                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f,model.getLocalPosition().y+1.0f,0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();

                    TextView txt_name = (TextView)viewRenderable.getView();
                    txt_name.setText(name);
                    txt_name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            anchorNode.setParent(null);
                        }
                    });

                });




    }

    private void setClickListener() {
        for(int i=0;i<arrayView.length;i++)
            arrayView[i].setOnClickListener(this);


    }

    private void setArrayView()
    {
        arrayView = new View[]
                {
                        serena,centaurus,faisalmosque,monument,library,convention,parliment,nice,nustgatethree,nustgateten,nustmosque,seecs

                } ;   }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.serena) {
            selected = 1;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.centaurus)
        {
            selected = 2;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.faisalmosque)
        {
            selected = 3;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.monument)
        {
            selected = 4;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.nustlibrary)
        {
            selected = 5;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.convention)
        {
            selected = 6;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.parliment)
        {
            selected = 7;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.nice)
        {
            selected = 8;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.nustgatethree)
        {
            selected = 9;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.nustgateten)
        {
            selected = 10;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.nustmosque)
        {
            selected = 11;
            setBackground(view.getId());
        }
        else if(view.getId() == R.id.seecs)
        {
            selected = 12;
            setBackground(view.getId());
        }

    }

    private void setBackground(int id) {
        for(int i=0;i<arrayView.length;i++)
        {
            if(arrayView[i].getId() == id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);

        }
    }
}
