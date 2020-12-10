import React from 'react';
import AppBar from '@material-ui/core/AppBar';
import Button from '@material-ui/core/Button';
import CameraIcon from '@material-ui/icons/PhotoCamera';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import { Copyright } from '../../components/copyright/avantia';
import { useStyles } from './styles';
import camera01 from '../../assets/camera01.jpeg';
import camera02 from '../../assets/camera02.jpg';
import camera03 from '../../assets/camera03.jpeg';
import camera04 from '../../assets/camera04.jpeg';
import camera05 from '../../assets/camera05.jpeg';
import camera06 from '../../assets/camera06.jpeg';


export const cam1 = [1];
export const cam2 =[1];
export const cam3 =[1];
export const cam4 =[1];
export const cam5 =[1];
export const cam6 =[1];
export default function Album() {
  const classes = useStyles();
  return (
    <Grid container component="main" className={classes.root}>
      <CssBaseline />
      <AppBar position="relative">
        <Toolbar>
          <CameraIcon className={classes.icon} />
          <Typography variant="h6" color="inherit" noWrap>
            Câmeras
          </Typography>
        </Toolbar>
      </AppBar>
      <main>
        {/* Hero unit */}
        <Container className={classes.cardGrid} maxWidth="md">
          {/* End hero unit */}
          <Grid container spacing={4}>
            {cam1.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                <Card className={classes.card}>
                  <CardMedia className={classes.cardMedia}
                    image= { camera01 }
                    title="Portão D"
                  />
                  
                  <CardContent className={classes.cardContent}>
                    <Typography gutterBottom variant="h5" component="h2">
                      CÂMERA 01
                    </Typography>
                    <Typography>
                        Portão D - Lateral direita
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button size="small" color="primary">
                      Ampliar
                    </Button>
                  </CardActions>
                </Card>
              </Grid>
            ))}
            {cam2.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                <Card className={classes.card}>
                  <CardMedia className={classes.cardMedia}
                    image= { camera02 }
                    title="Arquibancada Superior"
                  />
                  
                  <CardContent className={classes.cardContent}>
                    <Typography gutterBottom variant="h5" component="h2">
                      CÂMERA 02
                    </Typography>
                    <Typography>
                        Arquibancada Superior - Time visitante
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button size="small" color="primary">
                      Ampliar
                    </Button>
                  </CardActions>
                </Card>
              </Grid>
            ))}
            {cam3.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                <Card className={classes.card}>
                  <CardMedia className={classes.cardMedia}
                    image= { camera03 }
                    title="Arquibancada Inferior"
                  />
                  
                  <CardContent className={classes.cardContent}>
                    <Typography gutterBottom variant="h5" component="h2">
                      CÂMERA 03
                    </Typography>
                    <Typography>
                        Arquibancada Inferior - Time da casa
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button size="small" color="primary">
                      Ampliar
                    </Button>
                  </CardActions>
                </Card>
              </Grid>
            ))}
            {cam4.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                <Card className={classes.card}>
                  <CardMedia className={classes.cardMedia}
                    image= { camera04 }
                    title="Image title"
                  />
                  
                  <CardContent className={classes.cardContent}>
                    <Typography gutterBottom variant="h5" component="h2">
                      CÂMERA
                    </Typography>
                    <Typography>
                        Estádio de Futebol
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button size="small" color="primary">
                      Ver
                    </Button>
                  </CardActions>
                </Card>
              </Grid>
            ))}
            {cam5.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                <Card className={classes.card}>
                  <CardMedia className={classes.cardMedia}
                    image= { camera05 }
                    title="Image title"
                  />
                  
                  <CardContent className={classes.cardContent}>
                    <Typography gutterBottom variant="h5" component="h2">
                      CÂMERA
                    </Typography>
                    <Typography>
                        Estádio de Futebol
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button size="small" color="primary">
                      Ver
                    </Button>
                  </CardActions>
                </Card>
              </Grid>
            ))}
            {cam6.map((card) => (
              <Grid item key={card} xs={12} sm={6} md={4}>
                <Card className={classes.card}>
                  <CardMedia className={classes.cardMedia}
                    image= { camera06 }
                    title="Image title"
                  />
                  
                  <CardContent className={classes.cardContent}>
                    <Typography gutterBottom variant="h5" component="h2">
                      CÂMERA
                    </Typography>
                    <Typography>
                        Estádio de Futebol
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button size="small" color="primary">
                      Ver
                    </Button>
                  </CardActions>
                </Card>
              </Grid>
            ))}
          </Grid>
        </Container>
      </main>
      {/* Footer */}
      <footer className={classes.footer}>
        <Copyright />
      </footer>
      {/* End footer */}
    </Grid>
  );
}

