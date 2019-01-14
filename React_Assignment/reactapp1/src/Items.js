import React,{ Component } from 'react';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogTitle from '@material-ui/core/DialogTitle';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
// import DialogTitle from '@material-ui/core/DialogTitle';
// const styles = theme => ({
//     root: {
//     },
//     table: {
//       minWidth: 700,
//       marginTop:300,
//     },
//   });
const rows=[{itemname:"Chapathi",itemcost:15,isAvailable:true},
    {itemname:"Dal",itemcost:20,isAvailable:true},
    {itemname:"Fry",itemcost:20,isAvailable:true},
    {itemname:"Curd",itemcost:10,isAvailable:true}
    ]
class Items extends Component{
    state={
        open:false,
    };
    openDialog=()=>{
        this.setState({open:true});
    }
    closeDialog=()=>{
        this.setState({open:false});
    }
    render(){
    return (
        <div>
            <Table >
                <TableHead>
                <TableRow>
                    <TableCell align="right" >ItemName</TableCell>
                    <TableCell align="right">Price</TableCell>
                    <TableCell align="right">isAvailable</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {rows.map(row => {
                    return (
                    <TableRow>
                        <TableCell align="right">{row.itemname}</TableCell>
                        <TableCell align="right">{row.itemcost}</TableCell>
                        <TableCell align="right">{row.isAvailable}</TableCell>
                    </TableRow>
                    );
                })}
                </TableBody>
            </Table>
          <Button align="right" onClick={this.openDialog}>Add New</Button>
          <Dialog open={this.state.open}
                onClose={this.closeDialog}
                aria-labelledby="form-dialog-title" >
            <DialogTitle id="form-dialog-title">Add New Item</DialogTitle>
            <DialogContent>
                ItemName:<TextField></TextField>
                Price:<TextField></TextField>
                <Button onClick={this.addItem}>Add Item</Button>
            </DialogContent>
          </Dialog>
        </div>
      );
    }
}
export default Items;