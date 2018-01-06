package com.aliak.dev.fastreading.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import rx.Observable
import rx.subjects.PublishSubject

/**
 * @author Aliaksandr Novik
 */
abstract class BaseAdapter<Model, Holder : BaseAdapter.AdapterViewHolder<Model>>(
        private val items: MutableList<Model> = mutableListOf())
    : RecyclerView.Adapter<Holder>() {
    private val itemClickSubject = PublishSubject.create<Model>()
    protected var observeClicks = true

    private var attachListener: View.OnAttachStateChangeListener? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView?) {
        super.onAttachedToRecyclerView(recyclerView)

        attachListener = object : View.OnAttachStateChangeListener {

            override fun onViewAttachedToWindow(p0: View?) {
                for (i in 0..itemCount) {
                    val vh = recyclerView?.findViewHolderForAdapterPosition(i)
                    if (vh != null && vh is AdapterViewHolder<*>) {
                        vh.init()
                    }
                }
            }

            override fun onViewDetachedFromWindow(p0: View?) {
                for (i in 0..itemCount) {
                    val vh = recyclerView?.findViewHolderForAdapterPosition(i)
                    if (vh != null && vh is AdapterViewHolder<*>) {
                        vh.release()
                    }
                }
            }
        }

        recyclerView?.addOnAttachStateChangeListener(attachListener)
    }

    override fun onViewAttachedToWindow(holder: Holder) {
        super.onViewAttachedToWindow(holder)
        if (holder != null) {
            holder.init()
            if (observeClicks) {
                holder.itemView?.setOnClickListener {
                    val pos = holder.adapterPosition
                    if (pos >= 0 && pos < items.size) {
                        itemClickSubject.onNext(items[pos])
                    }
                }
            }
        }
    }

    abstract fun createHolder(parent: ViewGroup?, viewType: Int): Holder

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Holder
            = createHolder(parent, viewType)

    open fun removeItem(position: Int): Model {
        val item = items.removeAt(position)
        notifyItemRemoved(position)
        return item
    }

    open fun moveItem(fromPosition: Int, toPosition: Int): Model {
        val model = items[fromPosition]
        val prev = items.removeAt(fromPosition)
        items.add(if (toPosition > fromPosition) toPosition - 1 else toPosition, prev)
        notifyItemMoved(fromPosition, toPosition)
        return model
    }

    open fun setItems(newItems: List<Model>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    fun insertItems(newItems: List<Model>) {
        items.addAll(newItems)
        notifyItemRangeInserted(0, newItems.size)
    }

    fun clearItems() {
        val count = items.count()
        items.clear()
        notifyItemRangeRemoved(0, count)
    }

    fun addItem(newItem: Model) {
        items.add(newItem)
        notifyItemInserted(itemCount - 1)
    }

    fun observeClickedItem(): Observable<Model> = itemClickSubject.asObservable()

    abstract class AdapterViewHolder<in Model>(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(item: Model, position: Int)
        abstract fun init()
        abstract fun release()
    }
}