import React from 'react';
import Link from '@material-ui/core/Link';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Title from '../Title';

// Generate Order Data
function createData(id, date, name, shipTo, paymentMethod, amount) {
  return { id, date, name, shipTo, paymentMethod, amount };
}

const rows = [
  createData(0, '16 Mar, 2020', 'João Mané', '2, Portao B', '0000021-99.2020.8.17.2001', 2),
  createData(1, '01 Mai, 2017', 'José McCartney', '1, Portão H', '0000041-99.2017.8.17.2001', 2),
  createData(2, '26 Nov, 2020', 'Marcio Barbosa', '2, Portao A', '0000088-99.2020.8.17.2001', 1),
  createData(3, '06 Fev, 2019', 'Miguel Jackson', '3, Portão C', '0000077-99.2019.8.17.2001', 5),
  createData(4, '15 Dez, 2018', 'Emerson Springsteen', '1, Portão D', '0000055-99.2018.8.17.2001', 3),
  createData(5, '01 Jun, 2019', 'Filipe Ted', '2, Portao A', '0000044-97.2019.8.17.2001', 1),
  createData(6, '06 Abr, 2020', 'Hemir Abreu', '3, Portão C', '0000011-89.2020.8.17.2001', 5),
  createData(7, '15 Dez, 2020', 'Thiago Springsteen', '1, Portão D', '0000666-99.2020.8.17.2001', 3),
];

function preventDefault(event) {
  event.preventDefault();
}

const useStyles = makeStyles((theme) => ({
  seeMore: {
    marginTop: theme.spacing(3),
  },
}));

export default function Orders() {
  const classes = useStyles();
  return (
    <React.Fragment>
      <Title>Notificações Recentes</Title>
      <Table size="small">
        <TableHead>
          <TableRow>
            <TableCell>Data</TableCell>
            <TableCell>Nome</TableCell>
            <TableCell>Câmera</TableCell>
            <TableCell>Processo Número</TableCell>
            <TableCell align="right">Jogos Sem Acesso</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {rows.map((row) => (
            <TableRow key={row.id}>
              <TableCell>{row.date}</TableCell>
              <TableCell>{row.name}</TableCell>
              <TableCell>{row.shipTo}</TableCell>
              <TableCell>{row.paymentMethod}</TableCell>
              <TableCell align="right">{row.amount}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
      <div className={classes.seeMore}>
        <Link color="primary" href="#" onClick={preventDefault}>
         Listar Mais 
        </Link>
      </div>
    </React.Fragment>
  );
}