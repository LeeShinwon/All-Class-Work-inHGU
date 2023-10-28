import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';

import '../app.dart';

class SearchPage extends StatelessWidget {
  const SearchPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Search'),
      ),
      body: Column(
        children: [
          Container(
            width: MediaQuery.of(context).size.width,
            height: MediaQuery.of(context).size.height - 220,
            child: ListView(
              children: [
                FilterExpansionPanel(),
                Divider(),
                Padding(
                  padding: const EdgeInsets.all(16.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text('Date',
                      style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 20,
                      ),),
                      DatePicker(),
                    ],
                  ),
                ),
              ],
            ),
          ),
          SearchButton(),
        ],
      )
    );
  }
}

class FilterExpansionPanel extends StatefulWidget {
  const FilterExpansionPanel({Key? key}) : super(key: key);

  @override
  State<FilterExpansionPanel> createState() => _FilterExpansionPanelState();
}

class _FilterExpansionPanelState extends State<FilterExpansionPanel> {
  var _expanded = false;
  //var isCheckboxChecked = [false,false,false];
  var checkboxList = ['No Kids Zone','Pet-friendly','Free breakfast'];


  @override
  Widget build(BuildContext context) {

    return Padding(
      padding: const EdgeInsets.all(16.0),
      child: ExpansionPanelList(
        dividerColor: Colors.grey,
        elevation: 0,
        children: [
          ExpansionPanel(
            isExpanded: _expanded,
            canTapOnHeader: false,
            headerBuilder: (context,isExpanded){
              return const Row(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  Text('Filter',
                    style: TextStyle(
                    fontWeight: FontWeight.bold,
                    fontSize: 20,
                  ),
                  ),
                  Expanded(
                      child: Center(child:
                      Text('select filters',
                        style: TextStyle(
                          fontWeight: FontWeight.bold,
                          fontSize: 15,
                        ),
                      ),
                      ),
                  ),
                ],
              );
            },
            body: Row(
              children: [
                SizedBox(width: 120,),
                Expanded(
                  child: Column(
                    children: [
                      CustomCheckbox(0, checkboxList[0]),
                      CustomCheckbox(1, checkboxList[1]),
                      CustomCheckbox(2, checkboxList[2]),
                    ],
                  ),
                ),
              ],
            ),
          ),
        ],
        expansionCallback: (panelIndex, isExpanded){
          setState(() {
            _expanded = isExpanded;
          });
        },
      ),
    );
  }
  Widget CustomCheckbox(int index, String text){
    var appState = context.watch<SearchState>();

    return Row(
      mainAxisAlignment: MainAxisAlignment.start,
      children: [
        Checkbox(
          value: appState.checkedFilter[index],
          onChanged: (bool? value) {
            setState(() {
              appState.checkedFilter[index] = value!;
            });
          },
          //checkColor: Colors.white,
        ),
        Text(text),
      ],
    );
  }
}

class DatePicker extends StatefulWidget {
  DatePicker({Key? key}) : super(key: key);

  @override
  State<DatePicker> createState() => _DatePickerState();
}

class _DatePickerState extends State<DatePicker>{

  @override
  Widget build(BuildContext context) {
    var appState = context.watch<SearchState>();

    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('\u{1F5D3} check-in',
            style: TextStyle(
              fontWeight: FontWeight.bold,
              fontSize: 15,
            ),),
            appState.dateTime != null?
            Text(
              DateFormat('yyyy.MM.dd (E)').format(appState.dateTime!),
              style: TextStyle(
                color: Colors.grey,
              ),
           )
             : SizedBox(),
          ],
        ),
        ElevatedButton(
          onPressed: (){
            showDatePicker(
                context: context,
                initialDate: DateTime.now(),
                firstDate: DateTime(1900),
                lastDate: DateTime(2024),
            ).then((selectedDate){
              setState(() {
                appState.dateTime = selectedDate ?? DateTime.now();
              });
            });
          },
          child: Text('select date'),
        )
      ],
    );
  }

}


class SearchButton extends StatefulWidget {
  const SearchButton({Key? key}) : super(key: key);

  @override
  State<SearchButton> createState() => _SearchButtonState();
}

class _SearchButtonState extends State<SearchButton> {

  Future<void> _showMyDialog() async {
    return showDialog<void>(
      context: context,
      barrierDismissible: false, // user must tap button!
      builder: (BuildContext context) {
        var appState = context.watch<SearchState>();
        return AlertDialog(
          title: Center(
              child: const Text('Please check\nyour choice :)',
              style: TextStyle(
                fontSize: 20,
              ),)
          ),
          content: SingleChildScrollView(
            child: ListBody(
              children: <Widget>[
                Text("\u{1FAE5} " + appState.getCheckedList()),
                SizedBox(height: 20,),
                Text("\u{1F5D3} " + DateFormat('yyyy.MM.dd (E)').format(appState.dateTime!),),
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: const Text('Search'),
              onPressed: () {
                Navigator.of(context).pop();
                Navigator.of(context).pop();
              },
            ),
            TextButton(
              child: const Text('Cancle'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      width: MediaQuery.of(context).size.width,
      padding: EdgeInsets.all(16),
      child: ElevatedButton(
          onPressed: (){
            _showMyDialog();
          },
          child: Text('Search'),
      ),
    );
  }
}
