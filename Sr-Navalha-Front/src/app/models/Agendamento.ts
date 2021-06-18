import { UsuarioCliente } from './usuario-cliente';
import { Servico } from "./servico";
import { Endereco } from './endereco';

class Agendamento {
    id: any;
    data!: Date;
    horario: any;
    endereco!: Endereco;
    servico!: Servico;
    cliente!: UsuarioCliente
}

export { Agendamento };