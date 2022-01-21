package edu.um.coffe.model

import java.time.LocalDateTime

class Horario (_diaSemana: Int, _horaAbertura: LocalDateTime, _horaFecho: LocalDateTime) {
    private var diaSemana: Int
    private var horaAbertura: LocalDateTime
    private var horaFecho: LocalDateTime

    init {
        diaSemana = _diaSemana
        horaAbertura = _horaAbertura
        horaFecho = _horaFecho
    }

    fun getDiaSemana(): Int{
        return this.diaSemana
    }

    fun getHoraAbertura(): LocalDateTime{
        return this.horaAbertura
    }

    fun getHoraFecho(): LocalDateTime{
        return this.horaFecho
    }
}