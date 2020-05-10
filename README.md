# CS194A_Assignment2_MyMaps

## *Yiting Ji*

**My Maps** displays a list of maps, each of which show user-defined markers with a title, description, and location. The user can also create a new map. 

Time spent: **X** hours spent in total

## Functionality 

The following **required** functionality is completed:

* [x] The list of map titles is displayed.
* [x] After tapping on a map title, the associated markers in the map are shown.
* [x] The user is able to create a new map.

The following **extensions** are implemented:

* [x] Changed the color theme of the app.
* [x] Instead of the default marker, a custom marker drawable is used (speech bubble with place title as the text).

## Video Walkthrough

Here's a walkthrough of implemented user stories:

![](mymaps.gif)

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

* When adding Google maps to my app, the map won't show up despite adding the correct API keys and re-installing the app. It worked after a few hours without any changes on my end. So the reason for this bug is unknown.
* Could not get the transition animations to show up.
* Tried to add the function of deleting a map when an existing map is displayed by adding a delete button in the menu (similar to the save menu in the create_map view), but wasn't able to figure out how deleting the data and communicating with other views work.

## License

    Copyright [2020] [Yiting Ji]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
