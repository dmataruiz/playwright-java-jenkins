import http from 'k6/http';
import { sleep, check } from 'k6';

// Configuración de la carga
export const options = {
    vus: 10, // 10 usuarios virtuales concurrentes
    duration: '30s', // durante 30 segundos
};

export default function () {
    // Petición HTTP a la web objetivo
    const res = http.get('https://www.saucedemo.com/');

    // Validaciones
    check(res, {
        'status es 200': (r) => r.status === 200,
        'tiempo de respuesta < 500ms': (r) => r.timings.duration < 500,
    });

    sleep(1); // Espera de 1 segundo entre iteraciones
}