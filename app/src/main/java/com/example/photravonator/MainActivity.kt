package com.example.photravonator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    var currentImage= 0
    lateinit var image: ImageView
    var places= arrayOf("India Gate","Jama Masjid", "Lotus Temple", "Qutub-Minar", "Red Fort")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next= findViewById<ImageButton>(R.id.btnNext)
        val prev= findViewById<ImageButton>(R.id.btnPrev)
        var placeName= findViewById<TextView>(R.id.tVName)

        next.setOnClickListener {
            //i want to get the next image
            var idCurrentImageString= "pic$currentImage" //grabbed the ids in string format

            //getting the integer address with each of the views, so that logical operations can be performed on them
            //just finding the integer format of the string id, by this method below
            var idCurrentInageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image= findViewById(idCurrentInageInt)//got the image
            image.alpha= 0f

            //to get the next image
            currentImage= (5+currentImage+1)%5 //no. of the next image
            var idImageToShowString= "pic$currentImage" //grabbed the id of the next image in string
            var idInageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image= findViewById(idInageToShowInt)//got the image
            image.alpha= 1f

            placeName.text= places[currentImage]

        }

        prev.setOnClickListener {
            //i want to get the prev image
            var idCurrentImageString= "pic$currentImage" //grabbed the ids in string format

            //getting the integer address with each of the views, so that logical operations can be performed on them
            //just finding the integer format of the string id, by this method below
            var idCurrentInageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image= findViewById(idCurrentInageInt)//got the image
            image.alpha= 0f

            //to get the next image
            currentImage= (5+currentImage-1)%5 //no. of the next image
            var idImageToShowString= "pic$currentImage" //grabbed the id of the next image in string
            var idInageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image= findViewById(idInageToShowInt)//got the image
            image.alpha= 1f

            placeName.text= places[currentImage]
        }
    }
}



//in the begin, we will assume that i am at the 0th image and depnding upon the button, we will keep on changing it.
//'R.id.btnNext': the particular address of that view id. Its in Integer format.

/*LOGIC: IMAGE HANDLING
 1.I'll get th eid of the current image in the variable 'idCurrentImageString'[in the string format (as its the id names)]
  Now,
  2.Converting the same id into an integer format
  I will actually make the image invisible by alpha=0
  **'idCurrentImageInt' & 'R.id.btnNext': are both ids, but to prevent specifying the id on each iteration, we will just create a variable which stores the id integer of the current image
  3. thus got the image
  4.setting that image to 0 i.e.' image.alpha=0
  and now, to get the next image
  5. just inc the value of the currentImge var+1
  and, now repeat
  but, alpha=1: as when i should click next, the current image should be invisible[alpha=0] & the next image to be visible[alpha=1] */

/*id liya[string]...id se uski integer value nikali.....us value pr operation kiye....us value ki pic nikali[fingViewById() lagakar] */

//DAAAAMMNNNNNNNNN POINT: (5+currentImage+1)%5: mathematical to handle the forward corner key...itself takes the 0 after 4th value been done
// //ly for the Prev corner key: (5+currentImage-1)%5
//placeName.text= places[currentImage]

/* TEXT HANDLING
We will create an array of the places names in sequence.
and just giving it the value of the current image integer asso. with it.*/