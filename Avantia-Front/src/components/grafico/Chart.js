import React from 'react';
import { useTheme } from '@material-ui/core/styles';
import { LineChart, Line, XAxis, YAxis, Label, ResponsiveContainer } from 'recharts';
import Title from '../Title';

// Generate Sales Data
function createData(time, amount) {
  return { time, amount };
}

const data = [
  createData('14:00', 0),
  createData('15:00', 3),
  createData('16:00', 26),
  createData('17:00', 15),
  createData('17:30', 45),
  createData('18:00', 58),
  createData('18:30', 50),
  createData('19:00', 30),
  createData('19:30', 15),
  createData('20:00', 10),
  createData('20:30', 5),
  createData('21:00', 30),
  createData('21:30', 7),
  createData('22:00', 7),
];

export default function Chart() {
  const theme = useTheme();

  return (
    <React.Fragment>
      <Title>Jogo Hoje - Arena Pernambuco</Title>
      <ResponsiveContainer>
        <LineChart
          data={data}
          margin={{
            top: 16,
            right: 16,
            bottom: 0,
            left: 24,
          }}
        >
          <XAxis dataKey="time" stroke={theme.palette.text.secondary} />
          <YAxis stroke={theme.palette.text.secondary}>
            <Label
              angle={270}
              position="left"
              style={{ textAnchor: 'middle', fill: theme.palette.text.primary }}
            >
              Notificações
            </Label>
          </YAxis>
          <Line type="monotone" dataKey="amount" stroke={theme.palette.primary.main} dot={false} />
        </LineChart>
      </ResponsiveContainer>
    </React.Fragment>
  );
}