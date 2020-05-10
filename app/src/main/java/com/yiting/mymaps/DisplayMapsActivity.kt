package com.yiting.mymaps

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.maps.android.ui.IconGenerator
import com.google.maps.android.ui.IconGenerator.*
import com.yiting.mymaps.models.UserMap

private const val TAG = "DisplayMapsActivity"
class DisplayMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var userMap: UserMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_maps)

        userMap = intent.getSerializableExtra(EXTRA_USER_MAP) as UserMap
        supportActionBar?.title = userMap.title
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        Log.i(TAG, "user map to render: ${userMap.title}")

        val iconGenerator = IconGenerator(this@DisplayMapsActivity)
        iconGenerator.setStyle(STYLE_BLUE)
//        iconGenerator.setColor(R.color.colorPrimaryDark)
//        iconGenerator.setBackground(getResources().getDrawable()(R.color.colorPrimaryDark))
        val boundsBuilder = LatLngBounds.Builder()

        val iterator = userMap.places.iterator()
        for ((index, place) in iterator.withIndex()) {
            val latLng = LatLng(place.latitude, place.longitude)
            boundsBuilder.include(latLng)
            val bitmap: Bitmap = iconGenerator.makeIcon((index + 1).toString())
            val icon: BitmapDescriptor = BitmapDescriptorFactory.fromBitmap(bitmap)
            mMap.addMarker(MarkerOptions()
                .position(latLng)
                .title(place.title)
                .snippet(place.description)
                .icon(icon))
        }

        // Add a marker in Sydney and move the camera
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 1000, 1000, 0))
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_delete_map, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == R.id.miDelete) {
//            Log.i(TAG, "Tapped on delete")
//            val data = Intent()
//            setResult(Activity.RESULT_OK, data)
//            finish()
//            return true
//        }
//        return super.onOptionsItemSelected(item)
//    }

//    private fun showAlertDialog() {
//        val mapDeleteView = LayoutInflater.from(this).inflate(R.layout.dialog_delete_map, null)
//        val dialog =
//            AlertDialog.Builder(this)
//                .setTitle("Are you sure you want to delete this map?")
//                .setView(mapDeleteView)
//                .setNegativeButton("Cancel", null)
//                .setPositiveButton("OK", null)
//                .show()
//
//        dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener{
//            val title = mapDeleteView.findViewById<EditText>(R.id.etTitle).text.toString()
//            if (title.trim().isEmpty()) {
//                Toast.makeText(this, "Map must have non-empty title", Toast.LENGTH_LONG).show()
//                return@setOnClickListener
//            }
//
//            // Navigate to create map activity
//            val intent = Intent(this@DisplayMapsActivity, CreateMapActivity::class.java)
//            intent.putExtra(EXTRA_MAP_TITLE, title)
//            startActivityForResult(intent, REQUEST_CODE)
//
//            dialog.dismiss()
//        }
//    }
}
